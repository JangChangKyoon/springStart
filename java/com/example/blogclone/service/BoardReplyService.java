package com.example.blogclone.service;

import com.example.blogclone.dto.BoardDto;
import com.example.blogclone.dto.ReplytDto;
import com.example.blogclone.model.Board;
import com.example.blogclone.model.Reply;
import com.example.blogclone.repository.BoardRepository;
import com.example.blogclone.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;


    @Autowired
    public BoardReplyService(ReplyRepository replyRepository, BoardRepository boardRepository){
        this.replyRepository = replyRepository;
        this.boardRepository = boardRepository;
    }

    public void registerReplies(ReplytDto requestDto) {
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        Reply reply = new Reply(title, content);
        replyRepository.save(reply);
    }

    public void registerBoard(BoardDto requestDto) {
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        Board board = new Board(title, content);
        boardRepository.save(board);
    }
}
