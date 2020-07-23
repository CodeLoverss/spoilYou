package com.ytz.spoilyou.mapper;

import com.ytz.spoilyou.entity.Pet;
import com.ytz.spoilyou.entity.PetDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PetMapper {
    //查询所有宠物
    @Select("select * from petdetail")
    List<PetDetail> findAllPet();

    @Select("select * from petdetail where state!='已领养'")
    List<PetDetail> findAllAdoptPet();

    @Select("select * from petdetail order by id desc limit 12")
    List<PetDetail> findSomePet();

    @Select("select * from petdetail where kind=#{kindId}")
    List<PetDetail> findPetByKindId(String kindId);

    //通过pno（对应宠物的id）查询宠物详情
    @Select("select * from petdetail where pno=#{id}")
    PetDetail findPetDetailById(int id);

    //通过pno(对应宠物的id)添加宠物详情
    @Insert("insert into petdetail(pno,name,age,birth,sex,picture,brief,kind) values(#{pno},#{name},#{age},#{birth},#{sex},#{picture},#{brief},#{kind})")
    boolean addPetDetail(PetDetail petDetail);

    //更新宠物详情信息   ,describe=#{describe}
    @Update("update petdetail set name=#{name},age=#{age},birth=#{birth},sex=#{sex},brief=#{brief} where pno=#{pno}")
    boolean updatePet(PetDetail petDetail);

    //删除宠物
    @Delete("delete from petdetail where pno=#{pno}")
    boolean delPet(int pno);

    @Insert("insert into kind(name) values(#{name})")
    boolean addKind(String name);

    @Select("select * from petdetail where name like #{petname}")
    List<PetDetail> searchPetByName(String petname);

}
