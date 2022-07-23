package com.example.jpalombok.controller;

import com.example.jpalombok.domain.Course;
import com.example.jpalombok.domain.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseRepository courseRepository;

    //get 요청이 오는 경우 발동하는 매소드
    //브라우저에서 http://localhost:8080/api/courses 입력
    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}