package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.Pet;
import com.ytz.spoilyou.entity.PetDetail;

import java.util.List;

public interface PetDetailService {
    //管理员增加宠物详情
    boolean addPetDetail(PetDetail petDetail);

    //管理员更新宠物详情
    boolean updatePet(PetDetail petDetail);

    //根据pno（对应宠物的id）查询宠物详情
    PetDetail findPetDetailById(int id);
}
