package com.example.notiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching //todo cache clustering 필요 (redis 사용 예정)
public class NotiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotiServiceApplication.class, args);
    }

}
