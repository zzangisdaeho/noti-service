package com.example.notiservice.domain.channel;

import com.example.notiservice.domain.system_profile.SocialNetworkSystemProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SocialNetworkNotification extends NotificationChannel{

    private String senderSocialNetworkId;
    private String receiverSocialNetworkId;
    private SocialNetworkSystemProfile targetSocialNetworkSystem;

    public SocialNetworkNotification(String transactionId, String senderSocialNetworkId, String receiverSocialNetworkId, SocialNetworkSystemProfile targetSocialNetworkSystem) {
        super(transactionId);
        this.senderSocialNetworkId = senderSocialNetworkId;
        this.receiverSocialNetworkId = receiverSocialNetworkId;
        this.targetSocialNetworkSystem = targetSocialNetworkSystem;
    }
}
