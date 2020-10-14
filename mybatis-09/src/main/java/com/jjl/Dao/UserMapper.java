package com.jjl.Dao;

import com.jjl.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUser(int id);
}
