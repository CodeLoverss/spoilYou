package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.User;

public interface LoginService {
    //通过用户名密码来查找用户
    User findUser(String username,String password);

}
