package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.Pet;

import java.util.List;

public interface PetService {

    //管理员增加宠物
    boolean addPet(Pet pet);

    //管理员删除宠物
    boolean delPetById(int id);

    //管理员更新宠物信息
    boolean updatePet(Pet pet);

    List<Pet> findAllPet();
}
