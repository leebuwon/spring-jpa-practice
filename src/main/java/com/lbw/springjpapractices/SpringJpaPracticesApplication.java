package com.lbw.springjpapractices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringJpaPracticesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaPracticesApplication.class, args);
    }

}
