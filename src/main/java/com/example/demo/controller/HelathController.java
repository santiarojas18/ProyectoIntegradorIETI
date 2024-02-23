package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelathController {
    @RequestMapping("/health")
    public String checkAPI(){
        return "<h1>The API is working ok!</h1>";
   }
}
