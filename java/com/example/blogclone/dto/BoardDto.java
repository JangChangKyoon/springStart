package com.example.blogclone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardDto {
    private String title;
    private String content;

//    public BoardDto(String title, String content){//, Timestamped createAt, Timestamped modifiredAt) {
//        this.title = title;
//        this.content = content;}
//        this.createdAt = createAt;
}
