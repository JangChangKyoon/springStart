package com.example.projectmemoreview.controller;

import com.example.projectmemoreview.domain.Review;
import com.example.projectmemoreview.domain.ReviewRepository;
import com.example.projectmemoreview.domain.ReviewRequestDto;
import com.example.projectmemoreview.sevice.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

//    @GetMapping("/api/reviews")
//    public List<Review> getReview() {
////        return reviewRepository.findAll();
//        List<Review> reviewList = reviewRepository.findAll();
//        for (int i=0; i<reviewList.size(); i++) {
//            Review review = reviewList.get(i);
//            return review;
//        }

//            System.out.println(review.getId());
//            System.out.println(review.getTitle());
//            System.out.println(review.getContent());
//            System.out.println(review.getAuthor());







    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/reviews")
    public Review createReview(@RequestBody ReviewRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Review이니, Dto의 정보를 review에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Review review = new Review(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return reviewRepository.save(review);
    }

    @DeleteMapping("/api/reviews/{id}")
    public boolean deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return reviewRepository.existsById(id);
    }

    @PutMapping("/api/reviews/{id}")
    public Long updateReview(@PathVariable Long id, @RequestBody ReviewRequestDto requestDto) {
        return reviewService.update(id, requestDto);
    }

}