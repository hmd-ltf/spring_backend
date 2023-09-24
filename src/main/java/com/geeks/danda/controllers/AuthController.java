package com.geeks.danda.controllers;

import com.geeks.danda.models.User;
import com.geeks.danda.models.requests.RegisterUser;
import com.geeks.danda.models.requests.UserLogin;
import com.geeks.danda.models.responses.ApiResponse;
import com.geeks.danda.models.responses.JwtResponse;
import com.geeks.danda.service.JwtService;
import com.geeks.danda.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;
    private final JwtService jwtService;

    @Autowired
    public AuthController(UsersService usersService, JwtService jwtService) {
        this.usersService = usersService;
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/register")
    public ApiResponse createUser(@RequestBody RegisterUser userData) {
        ApiResponse apiResponse = new ApiResponse();
        User newUser = usersService.createUser(userData);

        if (newUser != null) {
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setToken(jwtService.generateToken(newUser));
            apiResponse.setData(jwtResponse);
        } else {
            apiResponse.setMessage("User not created");
        }

        return apiResponse;
    }

    @GetMapping(value = "/authenticate")
    public ApiResponse userLogin(@RequestBody UserLogin userLogin) {
        ApiResponse apiResponse = new ApiResponse();
        User user = usersService.authenticateUser(userLogin);

        if (user != null) {
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setToken(jwtService.generateToken(user));
            apiResponse.setData(jwtResponse);
        } else {
            apiResponse.setMessage("Invalid credentials");
        }

        return apiResponse;
    }
}
