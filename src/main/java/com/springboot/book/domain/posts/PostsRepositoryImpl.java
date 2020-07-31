package com.springboot.book.domain.posts;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.book.web.dto.PostsResponseDslDto;
import com.springboot.book.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.springboot.book.domain.posts.QPosts.posts;

@Repository
@RequiredArgsConstructor
public class PostsRepositoryImpl implements PostsRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<PostsResponseDslDto> findAll2() {
        return queryFactory.select(Projections.fields(PostsResponseDslDto.class, posts.id, posts.title, posts.content, posts.author, posts.modifiedDate)).from(posts).orderBy(posts.id.desc()).fetch();
    }

    @Override
    public PostsResponseDslDto findByIdDsl(Long id) {
        return queryFactory.select(Projections.fields(PostsResponseDslDto.class, posts.id, posts.title, posts.content, posts.author, posts.modifiedDate)).from(posts).where(posts.id.eq(id)).fetchOne();
    }

    @Override
    public List<Posts> findByAuthor(String author) {
        return queryFactory.selectFrom(posts)
                .where(posts.author.eq(author))
                .fetch();
    }
}
