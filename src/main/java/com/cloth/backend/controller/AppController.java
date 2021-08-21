package com.cloth.backend.controller;

import com.cloth.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userDetails(){
        return userService.getUserDetails();
    }
}
