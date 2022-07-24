//domain은 테이블
//repository는 SQL
//JPA는 repository를 통해서만 사용 가능하다.

package com.example.projectmemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    //공식사이트:https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    //정렬기준
    List<Memo> findAllByOrderByModifiedAtDesc();
}