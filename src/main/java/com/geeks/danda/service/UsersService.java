package com.geeks.danda.service;

import com.geeks.danda.repositories.UsersRepository;
import com.geeks.danda.models.User;
import com.geeks.danda.models.requests.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User createUser(RegisterUser userRequest) {
        User user = null;
        boolean userCreated = false;

        if (userRequest != null) {
            user = new User();

            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            user.setEmail(userRequest.getEmail());

            userCreated = usersRepository.createUser(user);
        }

        if (!userCreated) {
            user = null;
        }

        return user;
    }

    public User fetchUserByUserName(String userName) {
        return usersRepository.findUserByUserName(userName);
    }
}
