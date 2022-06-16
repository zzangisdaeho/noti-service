package com.example.notiservice.domain.channel;

import com.example.notiservice.domain.system_profile.EmailSystemProfile;
import com.example.notiservice.domain.system_profile.SystemProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailNotification extends NotificationChannel{

    private String senderEmailAddress;
    private String receiverEmailAddress;
    private EmailSystemProfile targetEmailSystem;

    public EmailNotification(String transactionId, String type, String senderEmailAddress, String receiverEmailAddress, EmailSystemProfile targetEmailSystem) {
        super(transactionId, type);
        this.senderEmailAddress = senderEmailAddress;
        this.receiverEmailAddress = receiverEmailAddress;
        this.targetEmailSystem = targetEmailSystem;
    }

    //    @Override
//    protected String getType() {
//        return "email";
//    }
}
