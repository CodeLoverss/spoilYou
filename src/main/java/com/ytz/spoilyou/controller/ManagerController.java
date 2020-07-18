package com.ytz.spoilyou.controller;

import com.ytz.spoilyou.entity.User;
import com.ytz.spoilyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static com.ytz.spoilyou.constant.Constant.FALSE;
import static com.ytz.spoilyou.constant.Constant.SUCCESS;

//对pet和用户 CRUD
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    private HttpSession session;


    @RequestMapping("/addUser")
    public String addUser(User user){//注册
        boolean flag=userService.addUser(user);
        if (flag){
            session.setAttribute("state",SUCCESS);
            return "index";
        }else{
            session.setAttribute("state",FALSE);
            return "index?info=2";
        }
    }

    @RequestMapping("/delUser")
    public String delUser(@RequestParam int id){//删除用户
        boolean flag=userService.delUser(id);
        if (flag){
            session.setAttribute("state",SUCCESS);
            return "index";
        }else{
            session.setAttribute("state",FALSE);
            return "index?info=2";
        }
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user){//更新用户信息
        boolean flag=userService.updateUser(user);
        if (flag){
            session.setAttribute("state",SUCCESS);
            return "index";
        }else{
            session.setAttribute("state",FALSE);
            return "index?info=2";
        }
    }
}
