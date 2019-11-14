package com.yuan.config.userservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigController {

    @Value("${server.title}")
    private String title;

    @RequestMapping("title")
    public String getTitle(){
        return title;
    }
}
