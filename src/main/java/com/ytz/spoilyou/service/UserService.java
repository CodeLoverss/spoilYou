package com.ytz.spoilyou.service;

import com.ytz.spoilyou.entity.Adopt;
import com.ytz.spoilyou.entity.User;

import java.util.List;

public interface UserService {

    //管理员查询所有用户
    List<User> findAllUser();

    User getUserInfoById(String id);

    //增加用户
    boolean addUser(User user);
    List<User> repeatName(User user);

    //管理员删除用户 1:删除成功 0:删除失败
    boolean delUser(int id);

    //用户或管理员更新信息 1:更新成功 0:更新失败
    boolean updateUser(User user);

    boolean addAdopt(Adopt adopt);

    List<Adopt> findAdoptByUserId(int id);

    List<Adopt> findAllRequest();

    Adopt findAdoptByPetId(int id);

    boolean handleRequest(Adopt adopt);

    List<Adopt> findMyAdopt(int id);
    List<Adopt> findMyRequest(int id);

    List<Adopt> findRepeatRequest(int user_id,int pet_id);
}
