//crud

package com.example.projectmemo.controller;

import com.example.projectmemo.domain.Memo;
import com.example.projectmemo.domain.MemoRepository;
import com.example.projectmemo.domain.MemoRequestDto;
import com.example.projectmemo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 파라미터 자동으로 입력 해줌
@RestController// 생성자 자동 완성 -> 다른 곳에서 new MemoController 인스턴스 생략 가능하게 함
public class MemoController {
    //get, put, delete 가져오기
    // 맨버일 뿐아니라 필수적인 요소이므로 final을 붙여줌
    private final MemoRepository memoRepository;
    //update 가져오기
    private final MemoService memoService;

//    APT설계
//    메모 생성하기	POST	/api/memos	Memo
//    메모 조회하기	GET	/api/memos	List<Memo>
//    메모 변경하기	PUT	/api/memos/{id}	Long
//    메모 삭제하기	DELETE	/api/memos/{id}	Long

    @PostMapping("/api/memos")
    // 생성할 메모의 데이터를 가져오기 위해서 @RequestBody MemoRequestDto을 가져옴
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        //Memo 클래스에서 생성자를 가져옴
        Memo memo = new Memo(requestDto);
        // 가져와서 저장
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        //클래서 MemoRepositoy에서 기능 가져오기
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        //클래서 MemoRepositoy에서 기능 가져오기
        //@PathVariable Long id : id는 위 주소에 있는 것을 변수로 가져오는 것
        memoRepository.deleteById(id);
        return id;
    }
}