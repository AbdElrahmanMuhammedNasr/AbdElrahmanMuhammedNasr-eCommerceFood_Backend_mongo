package com.example.demo.zTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResContoller {

    @Autowired
    private Repo repo;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(){
        List<String> list = new ArrayList<>();
        list.add("facebook");
        list.add("youtube");
        list.add("insta");

        Map<String,String> map =new HashMap();
        map.put("foot","good");
        map.put("basket","very good");
        map.put("swimmang","bad");


        Entity e = new Entity();
        e.setName("Abdo");
        e.setLinks(list);
        e.setSport(map);

        repo.save(e);

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Entity> get(){
//        return repo.findAll();
        return repo.findAllById("606881b432334229925b8cf7");
    }
}
