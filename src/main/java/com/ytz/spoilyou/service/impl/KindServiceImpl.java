package com.ytz.spoilyou.service.impl;

import com.ytz.spoilyou.entity.Kind;
import com.ytz.spoilyou.mapper.KindMapper;
import com.ytz.spoilyou.service.KindService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindServiceImpl implements KindService {
    private KindMapper kindMapper;
    @Override
    public boolean addKind(Kind kind) {
        return kindMapper.addKind(kind);
    }

    @Override
    public boolean delKind(int id) {
        return kindMapper.delKind(id);
    }

    @Override
    public boolean updateKind(Kind kind) {
        return kindMapper.updateKind(kind);
    }

    @Override
    public List<Kind> findAllKind() {
        return kindMapper.findAllKind();
    }
}
