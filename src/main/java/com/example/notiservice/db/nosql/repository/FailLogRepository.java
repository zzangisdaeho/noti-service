package com.example.notiservice.db.nosql.repository;

import com.example.notiservice.db.nosql.document.FailLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FailLogRepository extends MongoRepository<FailLog, String> {
}
