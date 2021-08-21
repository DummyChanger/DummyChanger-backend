package com.cloth.backend.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private User(){};

    private static final User user=new User();

    public static User  getInstance(){
        return user;
    }


    public void show(){
        System.out.println("Work");
    }



    public static void main(String[] args){
        User u1=User.getInstance();
        u1.show();
        List<String> lsi =new ArrayList<>();

    }
}
