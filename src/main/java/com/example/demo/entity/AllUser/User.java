package com.example.demo.entity.AllUser;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Document
@Data
public class User {

    @Id
    private String id;
    private byte[] image;
    private String phone ;
    private String fullName;
    private String password;
    private String job;
    private String about;
    private List<String> links = new ArrayList<>();
    private Map<String,Integer> meta;
    private String state;
    private String city;
    private String street;
    private Date created;


}
