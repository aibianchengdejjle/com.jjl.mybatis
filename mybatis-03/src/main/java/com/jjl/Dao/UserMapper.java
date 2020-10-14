package com.jjl.Dao;

import com.jjl.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //根据用户id查询
    List<User> getUserByid(int id);
    //通过map来实现分页
   List<User> getUserBylimit(Map<String,Object>map);
   //通过RowBounds来实现分页
    List<User> getUserByRowBounds();

    //使用注解开发
    //查询
    @Select("select * from user")
    List<User> getUsers();
    //删除
    @Delete("delete  from user where id=#{id}")
    int DeletUserByid(int i);
    @Insert("insert into user values (#{id},#{name},#{pwd})")
    int add1(User swpu);
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int update(User user);
}
