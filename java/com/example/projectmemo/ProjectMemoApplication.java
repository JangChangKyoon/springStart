package com.example.projectmemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA사용 시 데이터 변동이 있으면 자동으로 반영
@SpringBootApplication
public class ProjectMemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMemoApplication.class, args);
    }

}
