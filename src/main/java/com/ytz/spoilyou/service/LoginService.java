package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.User;

public interface LoginService {

    User findUser(String username,String password);
}
