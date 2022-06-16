package com.example.notiservice.biz;

import com.example.notiservice.domain.channel.EmailNotification;
import com.example.notiservice.domain.channel.SocialNetworkNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SNSBiz implements ThirdPartyInterface{
    @Override
    public boolean support(Object channel) {
        return channel instanceof SocialNetworkNotification;
    }

    @Override
    @Async
    public CompletableFuture<String> send(Object channel, String title, String content) {
        SocialNetworkNotification socialNetworkNotification = (SocialNetworkNotification) channel;
        log.info("sending email... from {}, to {}, title: {}, content: {}", socialNetworkNotification.getSenderSocialNetworkId(), socialNetworkNotification.getReceiverSocialNetworkId(), title, content);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("send finish from {}, to {}, title: {}, content: {}", socialNetworkNotification.getSenderSocialNetworkId(), socialNetworkNotification.getReceiverSocialNetworkId(), title, content);
        return CompletableFuture.completedFuture(socialNetworkNotification.getReceiverSocialNetworkId());
    }
}