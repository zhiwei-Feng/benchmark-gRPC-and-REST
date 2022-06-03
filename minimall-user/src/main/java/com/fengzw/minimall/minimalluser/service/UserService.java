package com.fengzw.minimall.minimalluser.service;

import com.fengzw.minimall.minimalluser.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Long userId);
    void addNewUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
}
