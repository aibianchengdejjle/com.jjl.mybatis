package com.jjl.Dao;

import com.jjl.pojo.User;

import java.util.List;

public interface UserMapper {
    //根据用户id查询
    List<User> getUserByid(int id);
    //增加一个用户
    Integer addUser(User user);
    //更新一个用户用id
    int updateUser(User user);
    //删除一个用户
    int delete(int id);
    //获取用户的列表
    List<User> getUserList();
}
