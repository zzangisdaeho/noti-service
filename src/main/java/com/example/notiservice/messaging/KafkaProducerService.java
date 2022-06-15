package com.example.notiservice.messaging;

import com.example.notiservice.domain.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private static final String TOPIC = "send-result";
    private static final String TOPIC2 = "send-notification";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendResultMessage(String message){
      log.info("message : {}, send with topic {}", message, TOPIC);
      kafkaTemplate.send(TOPIC, message);
    }

    public void sendStartMessage(String notification){
        log.info("message : {}, send with topic {}", notification, TOPIC2);
        kafkaTemplate.send(TOPIC2, notification);
    }
}
