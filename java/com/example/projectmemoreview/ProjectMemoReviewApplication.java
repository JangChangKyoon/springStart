package com.example.projectmemoreview;

import com.example.projectmemoreview.domain.Review;
import com.example.projectmemoreview.domain.ReviewRepository;
import com.example.projectmemoreview.domain.ReviewRequestDto;
import com.example.projectmemoreview.sevice.ReviewService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing // controller와 연동
@SpringBootApplication
public class ProjectMemoReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMemoReviewApplication.class, args);
    }


//    @Bean // 이거 안 넣으니까 안 됨.
//    public CommandLineRunner demo(ReviewRepository reviewRepository, ReviewService reviewService) {
//        return (args) -> {
//            // 데이터 저장하기
//            reviewRepository.save(new Review("위대한개츠비","인간의꿈과욕망","스콧피츠제럴드"));
//            // 데이터 전부 조회하기
//            List<Review> reviewList = reviewRepository.findAll();
//            for (int i=0; i<reviewList.size(); i++) {
//                Review review = reviewList.get(i);
//                System.out.println(review.getId());
//                System.out.println(review.getTitle());
//                System.out.println(review.getContent());
//                System.out.println(review.getAuthor());
//
//            }
//            ReviewRequestDto requestDto = new ReviewRequestDto("노인과바다", "인생의의미","헤밍웨이");
//            reviewService.update(1L, requestDto);
//            reviewList = reviewRepository.findAll();
//            for (int i=0; i<reviewList.size(); i++) {
//                Review review = reviewList.get(i);
//                System.out.println(review.getId());
//                System.out.println(review.getTitle());
//                System.out.println(review.getContent());
//                System.out.println(review.getAuthor());
//            }
//        };
//    }


}
