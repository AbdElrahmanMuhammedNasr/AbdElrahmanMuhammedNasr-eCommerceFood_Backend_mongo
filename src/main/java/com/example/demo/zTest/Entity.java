package com.example.demo.zTest;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Document
@Data
public class Entity {
    @Id
    private String id;

    @Field
    private String name;

    private List<String> links;

    private Map<String, String> sport;
}
