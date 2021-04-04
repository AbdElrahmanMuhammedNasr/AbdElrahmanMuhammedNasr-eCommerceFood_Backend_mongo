package com.example.demo.entity.Cart;

import com.example.demo.entity.AllUser.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Cart {

    @Id
    private String id;

    private byte [] caImage;
    private String caName;
    private short caPrice;
    private String caProducer;
    private Date created; // after producer accept the order

    @DBRef
    private User user;
}
