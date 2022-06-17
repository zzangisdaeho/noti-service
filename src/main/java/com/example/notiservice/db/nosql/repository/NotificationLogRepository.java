package com.example.notiservice.db.nosql.repository;

import com.example.notiservice.db.nosql.document.NotificationLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationLogRepository extends MongoRepository<NotificationLog, String> {
}
