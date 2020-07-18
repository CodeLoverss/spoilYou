package com.ytz.spoilyou.mapper;

import com.ytz.spoilyou.entity.PetDetail;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PetDetailMapper {
    //通过pno（对应宠物的id）查询宠物详情
    @Select("select * from petdetail where pno=#{id}")
    PetDetail findPetDetailById(int id);

    //通过pno(对应宠物的id)添加宠物详情
    @Insert("insert into petdetail(pno,name,age,birth,sex,picture,describe) values(#{pno},#{name},#{age},#{birth},#{sex},#{picture},#{describe})")
    boolean addPetDetail(PetDetail petDetail);

    //更新宠物详情信息
    @Update("update petdetail set pno=#{pno},name=#{name},age=#{age},birth=#{birth},sex=#{sex},picture=#{picture},describe=#{describe}")
    boolean updatePet(PetDetail petDetail);

}
