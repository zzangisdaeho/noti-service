package com.example.notiservice.event;

import com.example.notiservice.domain.Notification;
import com.example.notiservice.domain.channel.NotificationChannel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@NoArgsConstructor
public class RetryEventDto {

    @Valid
    private NotificationChannel channel;

    private int retryCount;

    private String title;

    private String content;

    public RetryEventDto(NotificationChannel channel, int retryCount, String title, String content) {
        this.channel = channel;
        this.retryCount = retryCount;
        this.title = title;
        this.content = content;
    }
}
