package com.example.projectmemoreview.controller;

import com.example.projectmemoreview.domain.Review;
import com.example.projectmemoreview.domain.ReviewRepository;
import com.example.projectmemoreview.domain.ReviewRequestDto;
import com.example.projectmemoreview.sevice.ReviewService;
import org.springframework.web.bind.annotation.*;

//@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController  // JSON으로 데이터를 주고받음을 선언합니다.
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

    public ReviewController(ReviewRepository reviewRepository, ReviewService reviewService) {
        this.reviewRepository = reviewRepository;
        this.reviewService = reviewService;
    }
    //여기서 왜 꼭 final 사용하였어야 하는가??
    //final 변경 및 상속이 불가한 변수라 선언 // 강의에서는 반드시 있어야 하는 것이니 사용한다고 함.
    //repository의 맨버변수는 어떻게 생겼나?
    // return reviewRepository.save(review);에 사용할 용도라고 하는데
    // 메소드를 상속이 아닌 변수로 선언해서 사용하는가?




//     Post 진행 방식
//
//     1. 태이블 구성 id, title, content, author
//     2. post 입력
//        {
//            "title": "타이틀7",
//            "content":"내용",
//            "author":"저자",
//            "password":123
//        }
//
//    3. DTO 파라미터에 전달
//      (DTO bean)
//         public ReviewRequestDto(String title, String content, String author, Long password){//, Timestamped createAt, Timestamped modifiredAt) {
//            this.title = title;
//            this.content = content;
//            this.author = author;
//            this.password = password;
//
//    4. reviewRepository.save(review)가 Entitiy에 인식시키고 데이터베이스 저장
//     (ENTiTY bean)
//        public Review(ReviewRequestDto requestDto) {
//            this.title = requestDto.getTitle();
//            this.content = requestDto.getContent();
//            this.author = requestDto.getAuthor();
//            this.password = requestDto.getPassword();
//        }
//
//     매소드 참조변수는 내부 맴버변수를 파라미터로 활용하는 것? bean만 매서드 매개변수가 되는가?
//
//    리턴 형식으로 객체를 만들 수 있는가?
//    public Review updateReview(....){....
//        return new Review(requestDto);}
//
//    @RestController가 bean을 제이쓴으로 바꿔주는 것인자?

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


    @DeleteMapping("/api/reviews/{id}")
    public boolean deleteReview(@PathVariable Long id) {
        boolean bool = true;
        reviewRepository.deleteById(id);
        if (reviewRepository.existsById(id)) {
            return bool = false;
        }
        return bool;
    }

    @PutMapping("/api/reviews/{id}")
    // @RequestBody : body에 적은 내용을 자동으로 반영하게 해준다.
    public Review updateReview(@PathVariable Long id, @RequestBody ReviewRequestDto requestDto) {
        Review review = reviewService.update(id, requestDto);
        return review;
        //보통 Review review = new Review(requestDto); 이런 형식
        //객체를 선언하지 않고 바로 인스턴스 생성
    }
    @PatchMapping("/api/reviews/{id}")
    public Review patchReview(@PathVariable Long id, @RequestBody ReviewRequestDto requestDto) {
        reviewService.update(id, requestDto);
        return new Review(requestDto);
    }
}