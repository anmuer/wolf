package com.cc.wolf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cc")
public class HelloController {

    @GetMapping(value = "hello")
    public String hello(String param){
        return "hello "+param+" hei joy!";
    }

}
