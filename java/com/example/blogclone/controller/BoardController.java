package com.example.blogclone.controller;

import com.example.blogclone.dto.BoardDto;
import com.example.blogclone.repository.BoardRepository;
import com.example.blogclone.service.BoardReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    //    private BoardService boardService;
    private final BoardRepository boardRepository;
    private final BoardReplyService boardReplyService;

    public BoardController(BoardRepository boardRepository, BoardReplyService boardReplyService) {
        this.boardRepository = boardRepository;
        this.boardReplyService = boardReplyService;
    }

    @PostMapping("/api/board")
    public String contentUpload(@RequestBody BoardDto requestDto, Model model) {
        String title = requestDto.getTitle();
        System.out.println(title);
        model.addAttribute("visits1", title);
        boardReplyService.registerBoard(requestDto);
        return "board-view";
    }


//    public String registerUser(@RequestBody SignupRequestDto requestDto, Model model) {
//        String username = requestDto.getUsername();
//        String email = requestDto.getEmail();
//        String password = requestDto.getPassword();
//        System.out.println(username);
//        System.out.println(email);
//        System.out.println(password);
//        model.addAttribute("visits", username+email);
//        userService.registerUser(requestDto);
//
//        return "login";
//    }
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