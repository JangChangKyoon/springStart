package com.example.projectmemoreview;

import com.example.projectmemoreview.domain.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectMemoReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMemoReviewApplication.class, args);
    }

    public CommandLineRunner demo(ReviewRepository repository) {
        return (args) -> {

        };
    }


}
