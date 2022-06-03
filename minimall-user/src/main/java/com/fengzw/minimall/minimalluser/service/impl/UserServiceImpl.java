package com.fengzw.minimall.minimalluser.service.impl;

import com.fengzw.minimall.minimalluser.domain.User;
import com.fengzw.minimall.minimalluser.repository.UserRepository;
import com.fengzw.minimall.minimalluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()) {
            throw new IllegalArgumentException("user with id " + userId + " does not exist");
        }
        return byId.get();
    }

    @Override
    public void addNewUser(User user) {
        Optional<User> byUsername = userRepository.findByUsername(user.getUsername());
        if (byUsername.isPresent()) {
            throw new IllegalArgumentException("username existed");
        }
        Optional<User> byNickname = userRepository.findByNickname(user.getNickname());
        if (byNickname.isPresent()) {
            throw new IllegalArgumentException("nickname existed");
        }
        userRepository.save(user);
    }

    @Override
    @Transactional(rollbackOn = RuntimeException.class)
    public void updateUser(User user) {
        System.out.println(user);
        User exist = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("userId does not exist"));
        if (user.getNickname() != null && user.getNickname().length() > 0 && !user.getNickname().equals(exist.getNickname())) {
            Optional<User> byNickname = userRepository.findByNickname(user.getNickname());
            if (byNickname.isPresent()) {
                throw new IllegalArgumentException("nickname existed");
            }
            exist.setNickname(user.getNickname());
        }
        if (user.getPassword() != null && user.getPassword().length() > 0) {
            exist.setPassword(user.getPassword());
        }
        userRepository.save(exist);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()) {
            throw new IllegalArgumentException("userId does not exist");
        }
        userRepository.deleteById(userId);
    }
}
