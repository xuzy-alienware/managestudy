package com.bluezence.spring.managestudy.dao;

import com.bluezence.spring.managestudy.entity.User;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SQLManager sqlManager;

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

    public User getUserByName(String name){
        User query = new User();
        query.setName(name);
        List<User> list = sqlManager.select("user.selectSample", User.class, query);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    public int getUserCount(){
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }
}
