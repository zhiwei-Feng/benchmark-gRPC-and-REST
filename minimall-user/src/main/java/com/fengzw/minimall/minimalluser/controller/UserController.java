package com.fengzw.minimall.minimalluser.controller;


import com.fengzw.minimall.minimalluser.domain.User;
import com.fengzw.minimall.minimalluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @GetMapping(path = "{userId}")
    public User findUser(@PathVariable("userId") Long userId) {
        return userService.findUserById(userId);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String password,
                           @RequestParam(required = false) String nickname) {
        userService.updateUser(new User(userId, password, nickname));
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    // demo test
    @GetMapping("/demo")
    public User getUserDemo() {
        return new User(1L, "demo", "demo", "demo");
    }
}
