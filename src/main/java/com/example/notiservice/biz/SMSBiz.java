package com.example.notiservice.biz;

import com.example.notiservice.domain.channel.EmailNotification;
import com.example.notiservice.domain.channel.SMSNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SMSBiz implements ThirdPartyInterface{
    @Override
    public boolean support(Object channel) {
        return channel instanceof SMSNotification;
    }

    @Override
    @Async
    public CompletableFuture<String> send(Object channel, String title, String content) {
        SMSNotification smsNotification = (SMSNotification) channel;
        log.info("sending email... from {}, to {}, title: {}, content: {}", smsNotification.getSenderPhoneNumber(), smsNotification.getReceiverPhoneNumber(), title, content);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("send finish from {}, to {}, title: {}, content: {}", smsNotification.getSenderPhoneNumber(), smsNotification.getReceiverPhoneNumber(), title, content);
        return CompletableFuture.completedFuture(smsNotification.getReceiverPhoneNumber());
    }
}
