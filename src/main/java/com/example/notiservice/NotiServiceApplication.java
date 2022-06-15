package com.example.notiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NotiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotiServiceApplication.class, args);
    }

}
