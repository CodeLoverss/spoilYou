package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.User;

import java.util.List;

public interface UserService {

    //管理员查询所有用户
    List<User> findAllUser();

    //增加用户 1:注册成功 0:注册失败
    boolean addUser(User user);

    //管理员删除用户 1:删除成功 0:删除失败
    boolean delUser(int id);

    //用户或管理员更新信息 1:更新成功 0:更新失败
    boolean updateUser(User user);
}
