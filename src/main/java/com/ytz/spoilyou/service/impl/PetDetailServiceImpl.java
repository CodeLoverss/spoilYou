package com.ytz.spoilyou.service.impl;

import com.ytz.spoilyou.entity.PetDetail;
import com.ytz.spoilyou.mapper.PetDetailMapper;
import com.ytz.spoilyou.service.PetDetailService;
import org.springframework.stereotype.Service;

@Service
public class PetDetailServiceImpl implements PetDetailService {
    private PetDetailMapper petDetailMapper;

    @Override
    public boolean addPetDetail(PetDetail petDetail) {
        return petDetailMapper.addPetDetail(petDetail);
    }

    @Override
    public boolean updatePet(PetDetail petDetail) {
        return petDetailMapper.updatePet(petDetail);
    }

    @Override
    public PetDetail findPetDetailById(int id) {
        return petDetailMapper.findPetDetailById(id);
    }
}
