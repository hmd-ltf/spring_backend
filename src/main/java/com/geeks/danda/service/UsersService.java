package com.geeks.danda.service;

import com.geeks.danda.models.requests.UserLogin;
import com.geeks.danda.repositories.UsersRepository;
import com.geeks.danda.models.User;
import com.geeks.danda.models.requests.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(RegisterUser userRequest) {
        User user = null;
        boolean userCreated = false;

        if (userRequest != null) {
            user = new User();

            user.setUsername(userRequest.getUsername());
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            user.setEmail(userRequest.getEmail());

            userCreated = usersRepository.createUser(user);
        }

        if (!userCreated) {
            user = null;
        }

        return user;
    }

    public User authenticateUser(UserLogin userLogin) {
        User user = null;

        if (userLogin != null) {
            String userName = userLogin.getUserName();
            String providedPassword = userLogin.getPassword();
            String encodedPassword = usersRepository.fetchPasswordForUser(userName);

            if (encodedPassword != null && passwordEncoder.matches(providedPassword, encodedPassword)) {
                user = usersRepository.findUserByUserName(userLogin.getUserName());
            }
        }

        return user;
    }

}
