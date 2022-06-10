package com.example.notiservice.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    private static final String TOPIC = "send-result";

    @KafkaListener(topics = TOPIC)
    public void consume(Object message){
      log.info("receive message : {}", message);
    }
}
