package com.ijse.cmjdfinal.backend.service;

import com.ijse.cmjdfinal.backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
}
