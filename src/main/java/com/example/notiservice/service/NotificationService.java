package com.example.notiservice.service;

import com.example.notiservice.biz.ThirdPartyInterface;
import com.example.notiservice.domain.Notification;
import com.example.notiservice.domain.channel.NotificationChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private List<ThirdPartyInterface> thirdPartyServices;


    public void sendProcess(Notification notification){
        List<CompletableFuture<String>> futures = new ArrayList<>();

        notification.getNotificationChannels().forEach(notificationChannel -> {
            ThirdPartyInterface adaptor = choiceAdaptor(notificationChannel);
            CompletableFuture<String> send = adaptor.send(notificationChannel, notification.getTitle(), notification.getContent());
            futures.add(send);
        });

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
//                .thenApply()
                .join();
    }

    private ThirdPartyInterface choiceAdaptor(NotificationChannel notificationChannel) {
        return thirdPartyServices.stream().filter(thirdPartyService -> thirdPartyService.support(notificationChannel)).findFirst().orElseThrow(() -> new IllegalArgumentException("adaptor not found"));
    }

    private void validate(Notification notification){

    }
}
