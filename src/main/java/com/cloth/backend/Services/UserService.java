package com.cloth.backend.Services;

import com.cloth.backend.model.Role;
import com.cloth.backend.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);

    User getUser(String userName);

//    User login(String userName, String password);
}
