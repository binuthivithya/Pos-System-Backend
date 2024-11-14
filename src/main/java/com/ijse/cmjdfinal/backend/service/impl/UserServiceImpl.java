package com.ijse.cmjdfinal.backend.service.impl;

import com.ijse.cmjdfinal.backend.entity.User;
import com.ijse.cmjdfinal.backend.repository.UserRepository;
import com.ijse.cmjdfinal.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
