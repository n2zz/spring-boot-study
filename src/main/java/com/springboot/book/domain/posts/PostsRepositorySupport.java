package com.springboot.book.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import static com.springboot.book.domain.posts.QPosts.posts;
import java.util.List;

@Repository
public class PostsRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public PostsRepositorySupport(JPAQueryFactory queryFactory) {
        super(Posts.class);
        this.queryFactory = queryFactory;
    }

    public List<Posts> findByAuthor(String author) {
        return queryFactory.selectFrom(posts)
                .where(posts.author.eq(author))
                .fetch();
    }
}
