package com.geeks.danda.repositories;

import com.geeks.danda.repositories.RowMappers.UserMapper;
import com.geeks.danda.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createUser(User user) {
        boolean created;

        String INSERT_INTO_USERS = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
        created = 0 < jdbcTemplate.update(INSERT_INTO_USERS, user.getUsername(), user.getEmail(), user.getPassword());

        return created;
    }

    public User findUserByUserName(String name) {
        String FIND_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.query(FIND_USER_BY_USERNAME, new UserMapper(), name).stream().findFirst().orElse(null);
    }

    public String fetchPasswordForUser(String username) {
        String FETCH_PASSWORD_BY_NAME = "SELECT password FROM users WHERE username = ?";
        return jdbcTemplate.queryForList(FETCH_PASSWORD_BY_NAME, String.class, username).stream().findFirst().orElse(null);
    }

    public User findUserByEmail(String email) {
        String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.query(FIND_USER_BY_EMAIL, new UserMapper(), email).stream().findFirst().orElse(null);
    }

}

