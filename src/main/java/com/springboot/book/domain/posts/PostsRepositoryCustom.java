package com.springboot.book.domain.posts;

import com.springboot.book.web.dto.PostsResponseDslDto;

import java.util.List;

public interface PostsRepositoryCustom {
    List<PostsResponseDslDto> findAll2();
    PostsResponseDslDto findByIdDsl(Long id);
    List<Posts> findByAuthor(String author);
}
