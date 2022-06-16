package com.example.notiservice.domain.channel;

import com.example.notiservice.domain.system_profile.SMSSystemProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SMSNotification extends NotificationChannel{

    private String senderPhoneNumber;
    private String receiverPhoneNumber;
    private SMSSystemProfile targetSMSSystem;

    public SMSNotification(String transactionId, String type, String senderPhoneNumber, String receiverPhoneNumber, SMSSystemProfile targetSMSSystem) {
        super(transactionId, type);
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.targetSMSSystem = targetSMSSystem;
    }

    //    @Override
//    protected String getType() {
//        return "sms";
//    }
}
