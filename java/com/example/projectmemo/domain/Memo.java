//Memo 클래스 만들기
//    메모는 1) 익명의 작성자 이름(username), 2) 메모 내용(contents) 으로 이루어져 있습니다.
//MemoController.java 만들기 : CRD
//domain 패키지를 만듭니다.
//Timestamped.java
//MemoRepository 인터페이스 만들기
//MemoRequestDto 클래스 만들기
//MemoService 클래스 만들기 : U
//Memo.java에 update 메소드 추가하기

package com.example.projectmemo.domain;

import com.example.projectmemo.domain.MemoRequestDto;
import com.example.projectmemo.domain.Timestamped;
import lombok.Getter;

import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    //MemoService, MemoService 클래스와 연결
   public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}