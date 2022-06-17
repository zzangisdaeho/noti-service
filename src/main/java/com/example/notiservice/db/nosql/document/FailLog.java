package com.example.notiservice.db.nosql.document;

import com.example.notiservice.domain.Notification;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "failLogs")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FailLog extends LogFrame{

    @Id
    private String _id;

    public FailLog(Status status, Notification notification) {
        super(LocalDateTime.now(), status, notification, notification.getTitle(), notification.getContent());
    }
}
