package com.ytz.spoilyou.controller;

import com.ytz.spoilyou.entity.Pet;
import com.ytz.spoilyou.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//领养
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/adoptPet")
    public String adoptPet(User user, Pet pet){
        return null;
    }
}
