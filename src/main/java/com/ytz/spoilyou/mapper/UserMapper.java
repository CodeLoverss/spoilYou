package com.ytz.spoilyou.mapper;

import com.ytz.spoilyou.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有用户
    @Select("select * from user")
    List<User> findAllUser();

    //增加用户
    @Insert("insert into user(username,password,role) values(#{username},#{password},2)")
    boolean addUser(User user);

    //删除用户
    @Delete("delete from user where id=#{id}")
    boolean delUserById(int id);

    //更新用户信息
    @Update("update user set username=#{username},password=#{password},role=#{role}")
    boolean updateUser(User user);
}
