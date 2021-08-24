package com.cloth.backend.controller;

import com.cloth.backend.Services.MyUserDetailsService;
import com.cloth.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AppController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping("/")
    public List<User> userDetails() {
        return myUserDetailsService.getUsers();
    }

    @GetMapping(value = "/login")
    public String login() {
        return "Request received";
    }

    @PostMapping(value = "/v1")
    public String v1() {
        return "Request received";
    }

    @PostMapping(value = "/register")
    public Map<String, String> register(@RequestBody User user) {
        Map<String, String> msg = new HashMap<String, String>();
        try {
            myUserDetailsService.userRegister(user);
        } catch (Exception e) {
            msg.put("err", "User can't be added");
            return msg;
        }
        msg.put("sucess", "User added sucessful");
        return msg;
    }
}
