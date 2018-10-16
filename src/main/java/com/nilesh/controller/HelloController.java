package com.nilesh.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/ping")
    public String index() {
        return "pong";
    }
    
}
