package com.ytz.spoilyou.controller;

import com.ytz.spoilyou.entity.Kind;
import com.ytz.spoilyou.entity.Pet;
import com.ytz.spoilyou.entity.PetDetail;
import com.ytz.spoilyou.entity.User;
import com.ytz.spoilyou.service.KindService;
import com.ytz.spoilyou.service.LoginService;
import com.ytz.spoilyou.service.PetService;
import com.ytz.spoilyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.List;

//登录注册等等
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private KindService kindService;

    @Autowired
    private PetService petService;

    @Autowired
    private UserService userService;

    //默认跳转首页
    @RequestMapping("/")
    public String turnToIndex(Model model){
        //数据初始化
        List<Kind> kinds=kindService.findAllKind();
        model.addAttribute("currKinds",kinds);

        List<PetDetail> pets=petService.findSomePet();
        model.addAttribute("currPetsDetail",pets);
        return "index";
    }

    @RequestMapping("/toRegiste")
    public String toRegiste(HttpServletRequest request,Model model){

        return "registe";
    }

    @RequestMapping("/registe")
    public String registe(String username, String password,Model model){
        //username 不重复
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("用户");
        List<User> check_user=userService.repeatName(user);
        if(check_user==null||check_user.size()==0){
            userService.addUser(user);
            model.addAttribute("registe_success","注册成功快来登录吧");
            return "login";
        }
        else{
            model.addAttribute("registe_error","用户名重复");
            return "registe";
        }

    }


    //登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request,String username, String password,Model model){
        User user=loginService.findUser(username,password);
        List<Kind> kinds=kindService.findAllKind();
        model.addAttribute("currKinds",kinds);

        List<PetDetail> pets=petService.findSomePet();
        model.addAttribute("currPetsDetail",pets);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "index";
        }
        else return "login";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,Model model){
        List<Kind> kinds=kindService.findAllKind();
        model.addAttribute("currKinds",kinds);

        List<PetDetail> pets=petService.findSomePet();
        model.addAttribute("currPetsDetail",pets);
        request.getSession().setAttribute("user",null);
        return "index";
    }
}
