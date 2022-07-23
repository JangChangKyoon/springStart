package com.example.jpalombok;

import com.example.jpalombok.domain.Course;
import com.example.jpalombok.domain.CourseRepository;
import com.example.jpalombok.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing // Timestamp 반영(날짜 업데이트)
@SpringBootApplication
public class JpaLombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaLombokApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
		return (args) -> {
			// 데이터 삽입 insert
			courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
			// 데이터 조회 select
			System.out.println("데이터 인쇄");
			List<Course> courseList = courseRepository.findAll();
			for (int i=0; i<courseList.size(); i++) {
				Course course = courseList.get(i);
				System.out.println(course.getId());
				System.out.println(course.getTitle());
				System.out.println(course.getTutor());
			}
			// 데이터 변경 update
			Course new_course = new Course("웹개발의 봄, Spring", "임민영");
			courseService.update(1L, new_course);
			courseList = courseRepository.findAll();
			for (int i=0; i<courseList.size(); i++) {
				Course course = courseList.get(i);
				System.out.println(course.getId());
				System.out.println(course.getTitle());
				System.out.println(course.getTutor());
			}
		//데이터삭제
		courseRepository.deleteAll();

		};
	}

}



	// Week02Application.java 의 main 함수 아래에 붙여주세요.
//	@Bean
//	public CommandLineRunner demo(CourseRepository repository) {
//		return (args) -> {
//			Course course1 = new Course("내용1", "내용2");
//			repository.save(course1);
//
//			List<Course> courseList = repository.findAll();
//			for (int i = 0; i < courseList.size(); i++) {
//				Course c = courseList.get(i);
//				System.out.println(c.getId());
//				System.out.println(c.getTitle());
//				System.out.println(c.getTutor());
//			}
//			Course course = repository.findById(2L).orElseThrow(
//					() -> new NullPointerException("아이디가 존재하지 않습니다.")
//			);
//
//		};
//
//
//	}