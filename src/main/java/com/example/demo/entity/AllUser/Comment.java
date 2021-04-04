package com.example.demo.entity.AllUser;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document
public class Comment {

    @Id
    private String id;
    private String coComment;
    private Date created;

    @DBRef
    private User coUserId;
    @DBRef
    private User user;
}
