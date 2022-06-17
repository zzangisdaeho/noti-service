package com.example.notiservice.nosql;

import com.example.notiservice.db.nosql.document.SuccessLog;
import com.example.notiservice.db.nosql.repository.SuccessLogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class MongoTest {

    @Autowired
    SuccessLogRepository bookRepository;

    @Test
    void read(){
        List<SuccessLog> all = bookRepository.findAll();

        System.out.println("all = " + all);
    }

//    @Test
//    void write(){
//        SuccessLog book = new SuccessLog();
//        book.setName("test1");
//        book.setAuthor("daeho1");
//        bookRepository.save(book);
//    }
}
