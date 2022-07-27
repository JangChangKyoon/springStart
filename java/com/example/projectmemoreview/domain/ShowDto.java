package com.example.projectmemoreview.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Getter
@EnableJpaAuditing
@NoArgsConstructor //기본생성자 자동완성
public class ShowDto{

    private String title;
    private String content;
    private String author;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


    public ShowDto(Review review) {
        this.title = review.getTitle();
        this.author = review.getAuthor();
        this.content = review.getContent();
        this.createdAt =  review.getCreatedAt();
    }
}
