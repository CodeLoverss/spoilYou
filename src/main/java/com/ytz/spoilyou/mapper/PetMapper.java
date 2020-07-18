package com.ytz.spoilyou.mapper;

import com.ytz.spoilyou.entity.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PetMapper {
    //查询所有宠物
    @Select("select * from pet")
    List<Pet> findAllPet();

    //增加宠物
    @Insert("insert into pet(pno,name,kind) values(#{pno},#{name},#{kind})")
    boolean addPet(Pet pet);

    //删除宠物
    @Delete("delete from pet where id=#{id}")
    boolean delPetById(int id);

    //更新宠物信息
    @Update("update pet set pno=#{pno},name=#{name},kind=#{kind}")
    boolean updatePet(Pet pet);

}
