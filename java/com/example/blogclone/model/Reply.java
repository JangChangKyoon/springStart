package com.example.blogclone.model;

import com.example.blogclone.dto.ReplytDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter // Getter 생략가능하게 함.
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
@Setter
public class Reply {
    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;
    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private String author;



    public Reply(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    public Review(ShowDto requestDto) {
//        this.title = requestDto.getTitle();
//        this.content = requestDto.getContent();
//        this.author = requestDto.getAuthor();
//    }

    //    DTO로 변경 전
//    public void update(Review review) {
//        this.title = review.title;
//        this.content = review.content;
//        this.author = review.author;
//    }
    public void updateSevice(ReplytDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

//    public Review(ReviewRequestDto requestDto2) {
//        this.title = requestDto2.getTitle();
//        this.content = requestDto2.getContent();
//        this.author = requestDto2.getAuthor();
//        this.password = requestDto2.getPassword();
//    }
}