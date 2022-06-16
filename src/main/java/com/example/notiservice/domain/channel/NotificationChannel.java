package com.example.notiservice.domain.channel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = EmailNotification.class, name = "email"),
                @JsonSubTypes.Type(value = SMSNotification.class, name = "sms"),
                @JsonSubTypes.Type(value = SocialNetworkNotification.class, name = "sns"),
        }
)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class NotificationChannel {

    private String transactionId;

    private String type;

//    protected abstract String getType();
}
