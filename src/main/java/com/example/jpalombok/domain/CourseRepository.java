package com.example.jpalombok.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//interface 클래서에서 맵버가 빠진 매소드 모음집
//맴버 : 클래스 내에서 정의되어 이는 변수
public interface CourseRepository extends JpaRepository<Course, Long> {


}