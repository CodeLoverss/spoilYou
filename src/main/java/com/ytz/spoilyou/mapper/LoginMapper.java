package com.ytz.spoilyou.mapper;

import com.ytz.spoilyou.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    //寻找用户
    @Select("select * from user where username=#{username} and password=#{password}")
    User findUser(String username,String password);

}
