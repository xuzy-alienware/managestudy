package com.bluezence.spring.managestudy.dao;

import com.bluezence.spring.managestudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserById(Integer id){
        String sql = " select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
               User user = new User();
               user.setId(2);
                return null;
            }
        });
        return null;
    }

    public int getUserCount(){
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }
}
