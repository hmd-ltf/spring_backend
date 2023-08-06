package com.geeks.danda.service;

import com.geeks.danda.DAO.UsersDAO;
import com.geeks.danda.models.User;
import com.geeks.danda.models.requests.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public User createUser(RegisterUser userRequest) {
        User user = null;
        boolean userCreated = false;

        if (userRequest != null) {
            user = new User();

            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            user.setEmail(userRequest.getEmail());

            userCreated = usersDAO.createUser(user);
        }

        if (!userCreated) {
            user = null;
        }

        return user;
    }
}
