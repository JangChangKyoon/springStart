package com.example.blogclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.annotation.WebServlet;

@ServletComponentScan //@WebServlet 어노테이션이 동작하게 함
@SpringBootApplication
public class BlogCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogCloneApplication.class, args);
    }

}
