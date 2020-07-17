package com.ytz.spoilyou.controller;

import com.ytz.spoilyou.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//对pet和用户 CRUD
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping("/addUser")
    public String addUser(User user){

        return "index";
    }
}
