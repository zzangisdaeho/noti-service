package com.example.notiservice.domain.channel;

import com.example.notiservice.domain.system_profile.SocialNetworkSystemProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SocialNetworkNotification extends NotificationChannel{

    private String senderSocialNetworkId;
    private String receiverSocialNetworkId;
    private SocialNetworkSystemProfile targetSocialNetworkSystem;

    public SocialNetworkNotification(String transactionId, String type, String senderSocialNetworkId, String receiverSocialNetworkId, SocialNetworkSystemProfile targetSocialNetworkSystem) {
        super(transactionId, type);
        this.senderSocialNetworkId = senderSocialNetworkId;
        this.receiverSocialNetworkId = receiverSocialNetworkId;
        this.targetSocialNetworkSystem = targetSocialNetworkSystem;
    }

    //    @Override
//    protected String getType() {
//        return "sns";
//    }
}
