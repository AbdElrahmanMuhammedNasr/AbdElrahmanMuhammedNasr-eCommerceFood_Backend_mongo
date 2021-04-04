package com.example.demo.entity.Notifications;

import com.example.demo.entity.AllUser.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@Document
public class Notifications {

    @Id
    private String id;
    private String noName;
    private NotificationsResponseOptions noResponse; // order timeout  (accept  - reject )
    private Date start;
    private Date end;
    private char[] read = new char[1];

    @DBRef
    private User user;
}


// all possible response
enum  NotificationsResponseOptions {
    ORDER,
    TIMEOUT,
    ACCEPT,
    REJECT
}