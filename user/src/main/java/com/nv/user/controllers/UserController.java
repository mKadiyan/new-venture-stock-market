package com.nv.user.controllers;

import com.nv.user.dtos.CreateUserDto;
import com.nv.user.models.User;
import com.nv.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    private ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/users")
    private ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }
}
