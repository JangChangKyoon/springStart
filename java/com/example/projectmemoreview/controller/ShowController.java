package com.example.projectmemoreview.controller;

import com.example.projectmemoreview.domain.Review;
import com.example.projectmemoreview.domain.ReviewRepository;
import com.example.projectmemoreview.domain.ReviewRequestDto;
import com.example.projectmemoreview.domain.ShowDto;
import com.example.projectmemoreview.sevice.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor  // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController  // JSON으로 데이터를 주고받음을 선언합니다.
public class ShowController {
    private final ReviewRepository reviewRepository;


    @GetMapping("/api/reviews")
    public List<Review> getReview() {
        return reviewRepository.findAll();
    }

    @GetMapping("/api/reviews/{id}")
    public ShowDto getReview(@PathVariable Long id) {
        val review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return new ShowDto(review);
    }



    @PostMapping("/api/reviews/{id}")
    public boolean checkPassword(@RequestBody ReviewRequestDto requestDto, @PathVariable Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 비밀번호가 존재하지 않습니다.")
        );
        return review.getPassword().equals(requestDto.getPassword());
    }

}
