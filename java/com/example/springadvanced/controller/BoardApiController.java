package com.example.springadvanced.controller;

import com.example.springadvanced.dto.BoardDto;
import com.example.springadvanced.model.Board;
import com.example.springadvanced.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    //    private BoardService boardService;
    private final BoardRepository boardRepository;

    public BoardApiController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @PostMapping("/api/board")
    public Board contentUpload(@RequestBody BoardDto requestDto) {
        Board board  = new Board(requestDto);
        return boardRepository.save(board);
    }
//
//    @DeleteMapping("/api/board/{id}")
//    public ResponseDto<Integer> deleteById(@PathVariable int id){
//        boardService.글삭제하기(id);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
//
//    @PutMapping("/api/board/{id}")
//    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
//        System.out.println("BoardApiController : update : id : "+id);
//        System.out.println("BoardApiController : update : board : "+board.getTitle());
//        System.out.println("BoardApiController : update : board : "+board.getContent());
//        boardService.글수정하기(id, board);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
//
//    // 데이터 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.
//    // dto 사용하지 않은 이유는!!
//    @PostMapping("/api/board/{boardId}/reply")
//    public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
//        boardService.댓글쓰기(replySaveRequestDto);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
//
//    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
//    public ResponseDto<Integer> replyDelete(@PathVariable int replyId) {
//        boardService.댓글삭제(replyId);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
}