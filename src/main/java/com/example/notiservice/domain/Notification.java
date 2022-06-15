package com.example.notiservice.domain;

import com.example.notiservice.domain.channel.NotificationChannel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private String senderId;
    private String title;
    private String content;
    private String transactionId;
    private List<NotificationChannel> notificationChannels;
}
