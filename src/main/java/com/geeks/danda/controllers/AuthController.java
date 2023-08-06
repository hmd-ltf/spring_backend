package com.geeks.danda.controllers;


import com.geeks.danda.models.User;
import com.geeks.danda.models.requests.RegisterUser;
import com.geeks.danda.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;

    @Autowired
    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value = "/create")
    public User createUser(@RequestBody RegisterUser userData) {
        return usersService.createUser(userData);
    }
}
