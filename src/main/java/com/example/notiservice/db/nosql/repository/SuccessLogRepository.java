package com.example.notiservice.db.nosql.repository;

import com.example.notiservice.db.nosql.document.SuccessLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuccessLogRepository extends MongoRepository<SuccessLog, String> {
}
