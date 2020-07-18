package com.ytz.spoilyou.service.impl;

import com.ytz.spoilyou.entity.Pet;
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
    public boolean addPet(Pet pet) {
        return petMapper.addPet(pet);
    }

    @Override
    public boolean delPetById(int id) {
        return petMapper.delPetById(id);
    }

    @Override
    public boolean updatePet(Pet pet) {
        return petMapper.updatePet(pet);
    }

    @Override
    public List<Pet> findAllPet() {
        return petMapper.findAllPet();
    }
}
