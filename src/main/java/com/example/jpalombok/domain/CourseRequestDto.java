package com.example.jpalombok.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//DTO 데이터 변경의 안정성을 위해서 사용
@Getter // getter 자동 생성
@Setter // setter 자동 생성
@RequiredArgsConstructor // 생성자 자동 생성
public class CourseRequestDto {
    private final String title;
    private final String tutor;
}
