package com.example.blogclone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@NoArgsConstructor //기본생성자 자동완성
@Getter //getter 생략
//* DTO가 데이터 무분변할 변경의 완충제, 또는 데이터를 옮겨 다니는 것이라고 하는데 이해가되지 않는다.
public class ReplytDto {
    private String title;
    private String content;
}
