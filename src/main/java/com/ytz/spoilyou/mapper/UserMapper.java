package com.ytz.spoilyou.mapper;

import com.ytz.spoilyou.entity.Adopt;
import com.ytz.spoilyou.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有用户
    @Select("select * from user")
    List<User> findAllUser();

    @Select("select * from user where id=#{id}")
    User getUserInfoById(String id);

    //增加用户
    @Insert("insert into user(username,password,role) values(#{username},#{password},'用户')")
    boolean addUser(User user);
    //判断是否重名
    @Select("select * from user where username=#{username}")
    List<User> repeatName(User user);

    //删除用户
    @Delete("delete from user where id=#{id}")
    boolean delUserById(int id);

    //更新用户信息
    @Update("update user set username=#{username},password=#{password},role=#{role} where id=#{id}")
    boolean updateUser(User user);

    @Insert("insert into adopt(user_id,username,pet_id,petname,state) values(#{user_id},#{username},#{pet_id},#{petname},'申请')")
    boolean addAdopt(Adopt adopt);

    @Select("select * from adopt where user_id=#{user_id}")
    List<Adopt> findAdoptByUserId(int id);

    @Select("select * from adopt where state='申请'")
    List<Adopt> findAllRequest();

    @Select("select * from adopt where user_id=#{user_id} and pet_id=#{pet_id} and state='申请'")
    List<Adopt> findRepeatRequest(int user_id,int pet_id);

    @Select("select * from adopt where state='申请' and user_id=#{id}")
    List<Adopt> findMyRequest(int id);

    @Select("select * from adopt where state='领养' and user_id=#{id}")
    List<Adopt> findMyAdopt(int id);

    @Select("select * from adopt where pet_id=#{id}")
    Adopt findAdoptByPetId(int id);

    @Update("update adopt set state=#{state} where id=#{id}")
    boolean handleRequest(Adopt adopt);
    @Update("update petdetail set state='已领养' where pno=#{pet_id}")
    boolean addAdopt1(Adopt adopt);
}
