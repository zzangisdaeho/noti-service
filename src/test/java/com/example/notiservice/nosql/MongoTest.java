package com.example.notiservice.nosql;

import com.example.notiservice.db.nosql.document.Book;
import com.example.notiservice.db.nosql.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MongoTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void read(){
        List<Book> all = bookRepository.findAll();

        System.out.println("all = " + all);
    }

    @Test
    void write(){
        Book book = new Book();
        book.setName("test2");
        book.setAuthor("daeho2");
        bookRepository.save(book);
    }
}
