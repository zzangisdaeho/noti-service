package com.example.notiservice.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/kafka")
    public void sendMessage(String message){
        kafkaProducerService.sendMessage(message);
    }

}
