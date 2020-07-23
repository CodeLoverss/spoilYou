package com.ytz.spoilyou.mapper;

import com.ytz.spoilyou.entity.Kind;
import com.ytz.spoilyou.entity.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface KindMapper {
//    //增加宠物分类
//    @Insert("insert into kind(kno,name) values(#{kno},#{name})")
//    boolean addKind(Kind kind);
//
//    //删除宠物分类
//    @Delete("delete from kind where id=#{id}")
//    boolean delKind(int id);
//
//    //更改宠物分类信息
//    @Update("update kind set kno=#{kno},name=#{name}")
//    boolean updateKind(Kind kind);

    //查询所有分类
    @Select("select * from kind")
    List<Kind> findAllKind();

    @Select("select * from kind where name=#{name}")
    List<Kind> getIdByName(String name);

}
