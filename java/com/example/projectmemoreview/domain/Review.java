package com.example.projectmemoreview.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter // Getter 생략가능하게 함.
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Review extends Timestamped {
    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Long password;





//    @Getter로 생략 가능
//    public Long getId() {
//        return this.id;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getContent() {
//        return this.content;
//    }
//
//    public String getAuthor() {
//        return this.author;
//    }

//    public Review(String title, String content, String author) {
//        this.title = title;
//        this.content = content;
//        this.author = author;
//    }





    //DTO가 ETITY에 데이터를 전달하는 과정
    //     public ReviewRequestDto(String title, String content, String author, Long password){//, Timestamped createAt, Timestamped modifiredAt) {
    //        this.title = title;
    //        this.content = content;
    //        this.author = author;
    //        this.password = password;


    public Review(ReviewRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
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
    public void updateSevice(ReviewRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
    }

//    public Review(ReviewRequestDto requestDto2) {
//        this.title = requestDto2.getTitle();
//        this.content = requestDto2.getContent();
//        this.author = requestDto2.getAuthor();
//        this.password = requestDto2.getPassword();
//    }
}
