package com.example.notiservice.biz;

import com.example.notiservice.db.nosql.document.Status;
import com.example.notiservice.domain.channel.EmailNotification;
import com.example.notiservice.domain.channel.NotificationChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class EmailBiz implements ThirdPartyInterface{
    @Override
    public boolean support(Object channel) {
        return channel instanceof EmailNotification;
    }

    @Override
    @Async
    public CompletableFuture<NotificationChannel> send(Object channel, String title, String content) {
        EmailNotification emailNotification = (EmailNotification) channel;
        log.info("sending email... from {}, to {}, title: {}, content: {}", emailNotification.getSenderEmailAddress(), emailNotification.getReceiverEmailAddress(), title, content);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("send finish from {}, to {}, title: {}, content: {}", emailNotification.getSenderEmailAddress(), emailNotification.getReceiverEmailAddress(), title, content);

        emailNotification.setIsSuccess(Status.SUCCESS);
        return CompletableFuture.completedFuture(emailNotification);
    }
}
