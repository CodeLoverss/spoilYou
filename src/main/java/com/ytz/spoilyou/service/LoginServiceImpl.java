package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.User;
import com.ytz.spoilyou.mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    private LoginMapper loginMapper;

    @Override
    public User findUser(String username, String password) {
        return loginMapper.findUser(username,password);
    }
}
