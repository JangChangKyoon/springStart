package com.example.blogclone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false) // 대용량 데이터
    private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }




//    @ManyToOne(fetch = FetchType.EAGER)  // Many = Many,  User = One
//    @Column(name="userId")
//    private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

//    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요.
//    @JsonIgnoreProperties({"board"})
//    @OrderBy("id desc")
//    private List<Reply> replys;
//
//    @CreationTimestamp
//    private LocalDateTime createDate;
}