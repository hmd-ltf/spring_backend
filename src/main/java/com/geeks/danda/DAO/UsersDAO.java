package com.geeks.danda.DAO;

import com.geeks.danda.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO {

    private final String INSERT_INTO_USERS = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDAO() {
        this.jdbcTemplate = new JdbcTemplate();
    }

    public boolean createUser(User user) {
        boolean created;

        created = 0 < jdbcTemplate.update(INSERT_INTO_USERS, user.getUserName(), user.getEmail(), user.getPassword());

        return created;
    }

}
