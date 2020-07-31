package com.springboot.book.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDslDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    public PostsResponseDslDto() {}
    public PostsResponseDslDto(Long id, String title, String content, String author, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
