package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.Kind;

import java.util.List;

public interface KindService {
//    //增加宠物分类
//    boolean addKind(Kind kind);
//
//    //根据类别id删除宠物分类
//    boolean delKind(int id);
//
//    //更改宠物分类信息
//    boolean updateKind(Kind kind);

    //查询所有分类
    List<Kind> findAllKind();

    List<Kind> getIdByName(String name);
}
