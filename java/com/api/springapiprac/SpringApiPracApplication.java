package com.api.springapiprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing //Jpa에서 타임스템프 기능을 사용할 때 불러와주는 것
@SpringBootApplication
public class SpringApiPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiPracApplication.class, args);
    }

}
