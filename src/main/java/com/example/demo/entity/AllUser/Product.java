package com.example.demo.entity.AllUser;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Product {

    @Id
    private String id;
    private byte[] pImage;
    private String pName;
    private double pPrice;
    private double pTime;
    private String pCategory;
    private List<String> pIngredients;
    private List<String> pOverviews;
    private double pDiscount;
    private String pState;
    private String pCity;
    private String pStreet;
    private Date created;

    @DBRef
    private User user;


}
