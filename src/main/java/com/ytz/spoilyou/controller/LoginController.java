package com.ytz.spoilyou.controller;

import com.ytz.spoilyou.entity.User;
import com.ytz.spoilyou.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//登录注册等等
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    //默认跳转首页
    @RequestMapping("/")
    public String turnToIndex(){
        return "index";
    }

    //登录
    @RequestMapping("/login")
    public String login(String username,String password){
        User user=loginService.findUser(username,password);
        if(user!=null){
            return "index";
        }
        else return "login";
    }
}
