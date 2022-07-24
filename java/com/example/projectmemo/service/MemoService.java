// 업데이트

package com.example.projectmemo.service;

import com.example.projectmemo.domain.Memo;
import com.example.projectmemo.domain.MemoRepository;
import com.example.projectmemo.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor // 생성자 자동 완성
@Service
public class MemoService {

    //업데이트 내용 찾을 맴버변수
    private final MemoRepository memoRepository;

    @Transactional //DB에 업데이트 반영
    // public 반환타입 update(재료)
    public Long update(Long id, MemoRequestDto requestDto) {
        //memo 클래서 가봐
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}