package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.Pet;
import com.ytz.spoilyou.entity.PetDetail;

import java.util.List;

public interface PetService {

    //管理员增加宠物详情
    boolean addPetDetail(PetDetail petDetail);

    //管理员更新宠物详情
    boolean updatePet(PetDetail petDetail);

    //根据pno（对应宠物的id）查询宠物详情
    PetDetail findPetDetailById(int id);

    List<PetDetail> findAllPet();

    List<PetDetail> findSomePet();

    List<PetDetail> findPetByKindId(String kindId);

    boolean delPet(int pno);

    boolean addKind(String name);

    List<PetDetail> findAllAdoptPet();

    List<PetDetail> searchPetByName(String petname);
}
