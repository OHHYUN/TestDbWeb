package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String profile(){
        return this.profile;
    }
}
