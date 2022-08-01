package com.example.springadvanced.controller;
// 로그인 성공 후 홈화면에 이름 표시

import com.example.springadvanced.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "index";//타임리프는 templete에 있는 파일만 인식하므로 index를 옮겨야 함.
    }
}
