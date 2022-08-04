package com.example.blogclone.controller;

import com.example.blogclone.dto.ReplytDto;
import com.example.blogclone.model.Reply;
import com.example.blogclone.repository.ReplyRepository;
import com.example.blogclone.service.BoardReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // JSON으로 데이터를 주고받음을 선언합니다.
public class ReplyController {

    private final ReplyRepository replyRepository;
    private final BoardReplyService boardReplyService;

    public ReplyController(ReplyRepository replyRepository, BoardReplyService boardReplyService) {
        this.replyRepository = replyRepository;
        this.boardReplyService = boardReplyService;
    }

    @GetMapping("/api/replies")
    public List<Reply> getReview() {
        return replyRepository.findAll();
    }

    @PostMapping("/api/replies")
    public String CreateReply(@RequestBody ReplytDto requestDto, Model model) {
        // requestDto 는, 생성 요청을 의미합니다.
        // post요청시 바디에 있는 내용이 자동으로 파라미터 데이터를 채워서

        // 저장하는 것은 Dto가 아니라 Review이니, Dto의 정보를 review에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        System.out.println(title+content);
        String comment = requestDto.getContent();
        model.addAttribute("m", comment);

        boardReplyService.registerReplies(requestDto);
        return "board-view";


    }
    boolean bool = true;
    @DeleteMapping("/api/replies/{id}")
    public boolean deleteReview(@PathVariable Long id) {

        replyRepository.deleteById(id);
        if (replyRepository.existsById(id)) {
            return bool = false;
        }
        return bool;
    }

}
