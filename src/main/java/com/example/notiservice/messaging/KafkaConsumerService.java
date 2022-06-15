package com.example.notiservice.messaging;

import com.example.notiservice.domain.Notification;
import com.example.notiservice.service.NotificationService;
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

    private final NotificationService notificationService;

    @KafkaListener(topics = TOPIC)
    public void consume(String arrive) {
        log.info("receive message : {}", arrive);
        Notification notification = null;
        try {
            notification = objectMapper.readValue(arrive, Notification.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("notification = " + notification);

        notificationService.sendProcess(notification);

    }
}
