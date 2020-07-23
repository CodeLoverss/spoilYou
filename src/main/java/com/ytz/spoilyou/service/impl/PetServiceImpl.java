package com.ytz.spoilyou.service.impl;

import com.ytz.spoilyou.entity.Pet;
import com.ytz.spoilyou.entity.PetDetail;
import com.ytz.spoilyou.mapper.PetMapper;
import com.ytz.spoilyou.service.PetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PetServiceImpl implements PetService {
    @Resource
    private PetMapper petMapper;
    @Override
    public boolean addPetDetail(PetDetail petDetail) {
        return petMapper.addPetDetail(petDetail);
    }

    @Override
    public boolean updatePet(PetDetail petDetail) {
        return petMapper.updatePet(petDetail);
    }

    @Override
    public PetDetail findPetDetailById(int id) {
        return petMapper.findPetDetailById(id);
    }

    @Override
    public List<PetDetail> findAllPet() {
        return petMapper.findAllPet();
    }

    @Override
    public List<PetDetail> findSomePet() {
        return petMapper.findSomePet();
    }

    @Override
    public List<PetDetail> findPetByKindId(String kindId) {
        return petMapper.findPetByKindId(kindId);
    }

    @Override
    public boolean delPet(int pno) {
        return petMapper.delPet(pno);
    }

    @Override
    public boolean addKind(String name) {
        return petMapper.addKind(name);
    }

    @Override
    public List<PetDetail> findAllAdoptPet() {
        return petMapper.findAllAdoptPet();
    }

    @Override
    public List<PetDetail> searchPetByName(String petname) {
        petname="%"+petname+"%";
        return petMapper.searchPetByName(petname);
    }


}
