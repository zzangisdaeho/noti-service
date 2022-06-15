package com.example.notiservice.domain.channel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class NotificationChannel {

    private String transactionId;
}
