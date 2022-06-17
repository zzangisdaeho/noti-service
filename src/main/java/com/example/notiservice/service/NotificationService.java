package com.example.notiservice.service;

import com.example.notiservice.biz.ThirdPartyInterface;
import com.example.notiservice.db.nosql.document.Status;
import com.example.notiservice.domain.Notification;
import com.example.notiservice.domain.channel.NotificationChannel;
import com.example.notiservice.event.RetryEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final List<ThirdPartyInterface> thirdPartyServices;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void sendProcess(Notification notification) {

        List<CompletableFuture<NotificationChannel>> futures = new ArrayList<>();

        notification.getNotificationChannels().forEach(notificationChannel -> {
            CompletableFuture<NotificationChannel> sendFuture = choiceAdaptor(notificationChannel)
                    .send(notificationChannel, notification.getTitle(), notification.getContent())
                    .exceptionally(generateRetry(notificationChannel, notification.getTitle(), notification.getContent(), 1));
            futures.add(sendFuture);
        });

        List<NotificationChannel> join = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .thenApply(s -> futures.stream().map(CompletableFuture::join).toList())
                .join();

        log.info("====================================FIN===================================");

        System.out.println("join = " + join);
    }

    private ThirdPartyInterface choiceAdaptor(NotificationChannel notificationChannel) {
        return thirdPartyServices.stream()
                .filter(thirdPartyService -> thirdPartyService.support(notificationChannel))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("adaptor not found"));
    }

    private Function<Throwable, NotificationChannel> generateRetry(NotificationChannel channel,String title, String content, int retryCount) {
        return (throwable) -> {
            channel.setIsSuccess(Status.FAIL);
            applicationEventPublisher.publishEvent(new RetryEventDto(channel, retryCount, title, content));
            return channel;
        };
    }

    public void retryProcess(NotificationChannel notificationChannel, String title, String content, int retryCount) {
        CompletableFuture<NotificationChannel> sendFuture = choiceAdaptor(notificationChannel)
                .send(notificationChannel, title, content)
                .exceptionally(generateRetry(notificationChannel, title, content, retryCount));
    }
}
