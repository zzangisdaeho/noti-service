package com.example.notiservice.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private static final String TOPIC = "send-result";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String message){
      log.info("message : {}, send with topic {}", message, TOPIC);
      kafkaTemplate.send(TOPIC, message);
    }
}
