package com.example.notiservice.messaging;

import com.example.notiservice.domain.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private static final String TOPIC = "send-notification";

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = TOPIC)
    public void consume(String notification) {
        log.info("receive message : {}", notification);
        Notification arrive = null;
        try {
            arrive = objectMapper.readValue(notification, Notification.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("arrive = " + arrive);
    }
}
