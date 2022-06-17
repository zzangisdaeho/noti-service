package com.example.notiservice.db.nosql.document;

import com.example.notiservice.domain.Notification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "notificationLogs")
@Getter
@NoArgsConstructor
@ToString
public class NotificationLog extends LogFrame{

    @Id
    private String _id;

    public NotificationLog(Status status, Notification notification) {
        super(LocalDateTime.now(), status, notification, notification.getTitle(), notification.getContent());
    }
}
