package com.example.springadvanced.dto;


import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@NoArgsConstructor
@EnableJpaAuditing
@Getter
public class BoardDto {
    private String title;
    private String content;

    public BoardDto(String title, String content){//, Timestamped createAt, Timestamped modifiredAt) {
        this.title = title;
        this.content = content;}
//        this.createdAt = createAt;
}
