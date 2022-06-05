package com.example.notiservice.db.nosql.repository;

import com.example.notiservice.db.nosql.document.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
