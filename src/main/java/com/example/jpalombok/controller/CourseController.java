package com.example.jpalombok.controller;

import com.example.jpalombok.domain.Course;
import com.example.jpalombok.domain.CourseRepository;
import com.example.jpalombok.domain.CourseRequestDto;
import com.example.jpalombok.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {
    private final CourseRepository courseRepository;

    private final CourseService courseService;

    // ARC에서 요청 요령 : headers : Content-type, application/Json
    //{
    //  "title" : "앱개발 종합반",
    //  "tutor" : "김건희"
    //}
    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses")
    //@RequestBody 요청한 정보가 들어가게 해주는 어노테이션
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }



    //get 요청이 오는 경우 발동하는 매소드
    //브라우저에서 http://localhost:8080/api/courses 입력

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    //put요청
    // {id} : 변수가 들어갈 자리
    // put요청형식: http://localhost:8080/api/courses/1
    // ARC에서 요청 요령 : headers : Content-type, application/Json
    //body 내용용
   //{
    //  "title" : "앱개발 종합반",
    //  "tutor" : "김건희"
    //}
    @PutMapping("/api/courses/{id}")
    //@PathVariable : 위 {id}을 받아온다.
    //@RequestBody : 별경할 데이터 내용을 받아옴
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }

    @DeleteMapping("api/courses/{id}")
    purblic Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }


}