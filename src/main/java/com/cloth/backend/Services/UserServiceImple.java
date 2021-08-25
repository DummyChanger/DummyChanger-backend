package com.cloth.backend.Services;

import com.cloth.backend.model.Role;
import com.cloth.backend.model.User;
import com.cloth.backend.repository.RoleRepository;
import com.cloth.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImple implements UserService, UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public List<User> getUsers() {
        log.info("get all user form database");

        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        log.info("save user {}", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("save role {}", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("add new role");
        User user = userRepository.findByUsername(username);
        log.info("add new role");
        Role role = roleRepository.findByName(roleName);
        log.info("add new role");
        user.getRole().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("get  user {} form database", username);
        return userRepository.findByUsername(username);
    }

}
