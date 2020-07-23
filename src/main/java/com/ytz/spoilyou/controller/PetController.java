package com.ytz.spoilyou.controller;


import com.ytz.spoilyou.entity.Adopt;
import com.ytz.spoilyou.entity.Kind;
import com.ytz.spoilyou.entity.PetDetail;
import com.ytz.spoilyou.mapper.PetMapper;
import com.ytz.spoilyou.service.KindService;
import com.ytz.spoilyou.service.PetService;
import com.ytz.spoilyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private KindService kindService;

    @Autowired
    private UserService userService;

    @RequestMapping("/findByKind")
    public String findByKind(@RequestParam("id") String id, Model model){
        List<Kind> kinds=kindService.findAllKind();
        model.addAttribute("currKinds",kinds);

        List<PetDetail> list=petService.findPetByKindId(id);
        if(list!=null){
            model.addAttribute("currPetsDetail",list);
        }
        return "index";
    }

    @RequestMapping("/searchPetByName")
    public String searchPetByName(@RequestParam("petname") String petname, Model model){
        List<Kind> kinds=kindService.findAllKind();
        model.addAttribute("currKinds",kinds);

        List<PetDetail> petDetailList=petService.searchPetByName(petname);
        if(petDetailList!=null){
            model.addAttribute("currPetsDetail",petDetailList);
        }
        return "index";
    }

    @RequestMapping("/findAllPet")
    public String findAllPet(Model model){
        List<PetDetail> list=petService.findAllPet();
        if(list!=null){
            model.addAttribute("currPetsDetail",list);
        }
        return "admin-pets::f_content1";
    }

    @RequestMapping("/findAllAdoptPet")
    public String findAllAdoptPet(Model model){
        List<PetDetail> list=petService.findAllAdoptPet();
        if(list!=null){
            model.addAttribute("currPetsDetail",list);
        }
        return "admin-pets::f_content7";
    }

    @ResponseBody
    @RequestMapping("/getPetInfo")
    public PetDetail getPetInfo(@RequestParam("pno") int pno){
        PetDetail petDetail=petService.findPetDetailById(pno);
        return petDetail;
    }

    @RequestMapping("/findPetDetail")
    public String getPetDetail(@RequestParam("id") int id,
                                  Model model){
        PetDetail petDetail=petService.findPetDetailById(id);
        Adopt adopt=userService.findAdoptByPetId(petDetail.getPno());
        if (petDetail!=null){
            model.addAttribute("adopt",adopt);
            model.addAttribute("currPet",petDetail);
        }
        return "petsDetail";
    }


}
