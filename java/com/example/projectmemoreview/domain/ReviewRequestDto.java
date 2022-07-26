package com.example.projectmemoreview.domain;

public class ReviewRequestDto {
    private String title;
    private String content;
    private String author;

    public ReviewRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
