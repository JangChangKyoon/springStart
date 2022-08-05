package com.example.springadvanced.controller;

import com.example.springadvanced.dto.ReviewRequestDto;
import com.example.springadvanced.model.Review;
import com.example.springadvanced.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

@RestController  // JSON으로 데이터를 주고받음을 선언합니다.
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/api/reviews")
    public Review createReview(@RequestBody ReviewRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // post요청시 바디에 있는 내용이 자동으로 파라미터 데이터를 채워서

        // 저장하는 것은 Dto가 아니라 Review이니, Dto의 정보를 review에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Review review = new Review(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return reviewRepository.save(review);


    }
    boolean bool = true;
    @DeleteMapping("/api/reviews/{id}")
    public boolean deleteReview(@PathVariable Long id) {

        reviewRepository.deleteById(id);
        if (reviewRepository.existsById(id)) {
            return bool = false;
        }
        return bool;
    }

}
