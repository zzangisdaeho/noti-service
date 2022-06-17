package com.example.notiservice.db.nosql.document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public abstract class LogFrame {

    private LocalDateTime committedAt;

    private Status status;

    private Object details;

    private String title;

    private String content;
}
