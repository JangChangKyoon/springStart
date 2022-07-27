package com.example.projectmemoreview.sevice;

import com.example.projectmemoreview.domain.Review;
import com.example.projectmemoreview.domain.ReviewRepository;

import com.example.projectmemoreview.domain.ReviewRequestDto;
import com.example.projectmemoreview.domain.ShowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // 생성자 생략 가능
@Service
public class ReviewService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final ReviewRepository reviewRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    // * 뭘 의미하는 거지?
    // 파라미터에 자동으로 final 넣어줌

//    @RequiredArgsConstructor만들어 생성자 샐략가능능
//   public ReviewService(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Review update(Long id, ReviewRequestDto requestDto) {
        Review review1 = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        review1.updateSevice(requestDto);
        return review1;
    }
}
//    public Long patch(Long id, ReviewRequestDto requestDto) {
//        Review patch = reviewRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//        );
//        return
//    }
//}

//    @Transactional
//    public ShowDto findbyid(Long id) {
//        Review review1 = reviewRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//        );
//        return new ShowDto(review1);
//    }


