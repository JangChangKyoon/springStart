package com.example.projectmemoreview.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//interface는 맴버 변수와 파라미터 수를 협업에서 프로젝트 전에 결정하기 위한 것이라고 하는데
//왜 interface를 썻나?
//그리고 implement는 왜 생략되었다.
public interface ReviewRepository extends JpaRepository<Review, Long> {


}
