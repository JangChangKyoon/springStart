package com.example.projectmemoreview.controller;

import com.example.projectmemoreview.domain.Review;
import com.example.projectmemoreview.domain.ReviewRepository;
import com.example.projectmemoreview.domain.ReviewRequestDto;
import com.example.projectmemoreview.domain.ShowDto;
import com.example.projectmemoreview.sevice.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShowController {
    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

    @GetMapping("/api/reviews")
    public List<Review> getReview() {
        return reviewRepository.findAll();
    }

    @GetMapping("/api/reviews/{id}")
    public ShowDto getReview(@PathVariable Long id) {
        Review review = reviewRepository.findById(id).orElseThrow();
        return new ShowDto(review);
    }



    @PostMapping("/api/reviews/{id}")
    public boolean checkPassword(@RequestBody ReviewRequestDto requestDto, @PathVariable Long id) {
        Review review = reviewRepository.findById(id).orElseThrow();
        return review.getPassword().equals(requestDto.getPassword());
    }

}
