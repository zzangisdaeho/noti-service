package com.example.notiservice.biz;

import com.example.notiservice.domain.channel.EmailNotification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmailBiz implements ThirdPartyInterface{
    @Override
    public boolean support(Object channel) {
        return channel instanceof EmailNotification;
    }

    @Override
    @Async
    public CompletableFuture<String> send(Object channel, String title, String content) {
        EmailNotification emailNotification = (EmailNotification) channel;

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(emailNotification.getReceiverEmailAddress());
    }
}
