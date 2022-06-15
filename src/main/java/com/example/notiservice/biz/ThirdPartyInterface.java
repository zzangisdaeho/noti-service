package com.example.notiservice.biz;

import java.util.concurrent.CompletableFuture;

public interface ThirdPartyInterface {

    public boolean support(Object channel);

    public CompletableFuture<String> send(Object channel, String title, String content);
}
