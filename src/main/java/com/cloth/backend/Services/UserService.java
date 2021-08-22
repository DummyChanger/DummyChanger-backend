package com.cloth.backend.Services;

//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.cloth.backend.model.User;
import com.cloth.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUserDetails() {
        return userRepository.findAll();
    }

    public void addUser(User user) throws Exception{
        userRepository.save(user);
    }

}
