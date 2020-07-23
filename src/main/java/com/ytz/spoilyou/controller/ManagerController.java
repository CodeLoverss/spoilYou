package com.ytz.spoilyou.controller;

import com.ytz.spoilyou.entity.*;
import com.ytz.spoilyou.service.KindService;
import com.ytz.spoilyou.service.PetService;
import com.ytz.spoilyou.service.UserService;
import com.ytz.spoilyou.util.HandlePhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;


//对pet和用户 CRUD
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private PetService petService;

    @Autowired
    private KindService kindService;

    @RequestMapping("")
    public String turnToHomePage(HttpServletRequest request) {
        User user= (User) request.getSession().getAttribute("user");
        if(user!=null){
            return "admin-index";
        }
        return "index";
    }

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model){
        List<User> userList=userService.findAllUser();
        if(userList!=null&&userList.size()>0){
            model.addAttribute("userList",userList);
        }
        return "admin-pets::f_content4";

    }

    @ResponseBody
    @RequestMapping("/getUserInfoById")
    public User getUserInfoById(String id){
        return userService.getUserInfoById(id);
    }



    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(User user){//更新用户信息
        boolean flag=userService.updateUser(user);
        if (flag){
            return "success";
        }else{
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping("/alterPetInfo")
    public String alterPet(PetDetail petDetail){//更新宠物
        if(petService.updatePet(petDetail)){
            return"success";
        }
        else return "fail";

    }

    @ResponseBody
    @RequestMapping("/delPet")
    public String alterPet(@RequestParam("pno") int pno){//更新宠物
        if(petService.delPet(pno)){
            return"success";
        }
        else return "fail";

    }

    @ResponseBody
    @RequestMapping("/addPet")
    public String addPet(@RequestParam("pno") String pno,
                         @RequestParam("name") String name,
                         @RequestParam("age") String age,
                         @RequestParam("birth") String birth,
                         @RequestParam("sex") String sex,
                         @RequestParam("describe") String describe,
                         @RequestParam("kind") String kind,
                         @RequestParam("picture") MultipartFile picture
    ){//更新宠物
        PetDetail petDetail=new PetDetail();
        petDetail.setPno(Integer.parseInt(pno));
        petDetail.setName(name);
        petDetail.setAge(Integer.parseInt(age));
        petDetail.setBirth(birth);
        petDetail.setSex(sex);
        petDetail.setDescribe(describe);

        HandlePhoto handlePhoto=new HandlePhoto();
        try {
            petDetail.setPicture("images/pets/"+handlePhoto.handlePhoto(picture));

            List<Kind> kindList=kindService.getIdByName(kind);
            if(kindList==null||kindList.size()==0){
                return "error kind,please check it";
            }
            else{
                petDetail.setKind(kindList.get(0).getId());
            }
            if(petService.addPetDetail(petDetail)){
                return"success";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping("/addKind")
    public String addKind(@RequestParam("kind") String name){
        if(petService.addKind(name)) return "success";
        else return "fail";
    }

    @ResponseBody
    @RequestMapping("/applyAdopt")
    public String applyAdopt(HttpServletRequest request,@RequestParam("pet_id") int pet_id){
        Adopt adopt=new Adopt();
        PetDetail petDetail=petService.findPetDetailById(pet_id);
        if(petDetail!=null){
            adopt.setPet_id(pet_id);
            adopt.setPetname(petDetail.getName());
            User user= (User) request.getSession().getAttribute("user");
            adopt.setUser_id(user.getId());
            adopt.setUsername(user.getUsername());

            if(userService.addAdopt(adopt)) return "success";
        }

       return "fail";
    }

    @RequestMapping("/getApplies")
    public String getApplies(Model model){
        List<Adopt> adoptList=userService.findAllRequest();
        if(adoptList!=null&&adoptList.size()>0){
            model.addAttribute("adoptList",adoptList);
        }
        return "admin-pets::f_content6";
    }


    @ResponseBody
    @RequestMapping("/handleRequest")
    public String agreeAdopt(@RequestParam("id") int id,@RequestParam("user_id") int user_id,@RequestParam("pet_id") int pet_id,@RequestParam("state") String state){
        Adopt adopt=new Adopt();
        adopt.setId(id);
        adopt.setUser_id(user_id);
        adopt.setPet_id(pet_id);
        if(state.equals("agree"))adopt.setState("领养");
        else if(state.equals("refuse")) adopt.setState("拒绝");
        else return "error";
        userService.handleRequest(adopt);
        return "success";
    }

    @RequestMapping("/getMyApplies")
    public String getMyApplies(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        List<Adopt> applyList=userService.findMyRequest(user.getId());
        if(applyList!=null&&applyList.size()>0){
            model.addAttribute("applyList",applyList);
        }
        return "admin-pets::f_content8";
    }

    @RequestMapping("/getMyAdopts")
    public String getMyAdopts(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        List<Adopt> myAdoptList=userService.findMyAdopt(user.getId());
        if(myAdoptList!=null&&myAdoptList.size()>0){
            model.addAttribute("myAdoptList",myAdoptList);
        }
        return "admin-pets::f_content9";
    }




}
