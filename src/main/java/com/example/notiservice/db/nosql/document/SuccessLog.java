package com.example.notiservice.db.nosql.document;

import com.example.notiservice.domain.Notification;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "successLogs")
@Getter
@NoArgsConstructor
@ToString
public class SuccessLog extends LogFrame{

    @Id
    private String _id;

    public SuccessLog(Status status, Notification notification) {
        super(LocalDateTime.now(), status, notification, notification.getTitle(), notification.getContent());
    }
}
