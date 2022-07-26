package com.example.projectmemoreview.sevice;

import com.example.projectmemoreview.domain.Review;
import com.example.projectmemoreview.domain.ReviewRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ReviewService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final ReviewRepository reviewRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    // * 뭘 의미하는 거지?
    // 파라미터에 자동으로 final 넣어줌
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, Review review) {
        Review review1 = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        review1.update(review);
        return review1.getId();
    }
}
