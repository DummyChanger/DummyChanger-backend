package com.cloth.backend.controller;

import com.cloth.backend.Services.UserService;
import com.cloth.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AppController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> userDetails(){
        return userService.getUserDetails();
    }

    @PostMapping(value="/register")
    public Map<String,String> register(@RequestBody User user){
        Map<String,String> msg=new HashMap<String,String>();
        try{
            userService.addUser(user);
        }catch(Exception e) {
            msg.put("err","User can't be added");
            return msg;
        }
        msg.put("sucess","User added sucessful");
        return msg;
    }
}
