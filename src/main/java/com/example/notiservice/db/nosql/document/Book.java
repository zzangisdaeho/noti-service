package com.example.notiservice.db.nosql.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String _id;
    private String name;
    private String author;
}
