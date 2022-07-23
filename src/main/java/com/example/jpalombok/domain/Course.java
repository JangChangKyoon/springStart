package com.example.jpalombok.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //Lombok : getter를 생략 가능하도록 하는 어노이션
@NoArgsConstructor // Lombok : 기본생성자를 대신 생성해줍니다.
@Entity
//@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

//    Lombok으로 생략가능
//    public String getTitle() {
//        return this.title;
//    }
//    public String getTutor() {
//        return this.tutor;
//    }
//    public Long getId() {
//        return this.id;
//    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }


    //update는 서비스로만 구현 가능
    public void update(CourseRequestDto requestDto) {//Dto로 대체 Course course) {
        this.title = requestDto.getTitle(); //Dto로 대체 course.title;
        this.tutor = requestDto.getTutor(); //Dto로 대체 course.tutor;
    }


}