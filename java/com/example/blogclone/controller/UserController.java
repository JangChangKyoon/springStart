package com.example.blogclone.controller;

import com.example.blogclone.dto.SignupRequestDto;
import com.example.blogclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
//    @ResponseBody
    public String registerUser(@RequestBody SignupRequestDto requestDto, Model model) {
        String username = requestDto.getUsername();
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();
        System.out.println(username);
        System.out.println(email);
        System.out.println(password);
        model.addAttribute("visits", username+email);
        userService.registerUser(requestDto);

        return "login";
    }
}
