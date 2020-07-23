package com.ytz.spoilyou.service.impl;

import com.ytz.spoilyou.entity.Adopt;
import com.ytz.spoilyou.entity.User;
import com.ytz.spoilyou.mapper.UserMapper;
import com.ytz.spoilyou.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User getUserInfoById(String id) {
        return userMapper.getUserInfoById(id);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> repeatName(User user) {
        return userMapper.repeatName(user);
    }

    @Override
    public boolean delUser(int id) {
        return userMapper.delUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean addAdopt(Adopt adopt) {
       if(userMapper.addAdopt(adopt))return true;
       else return false;
    }

    @Override
    public List<Adopt> findAdoptByUserId(int id) {
        return userMapper.findAdoptByUserId(id);
    }

    @Override
    public List<Adopt> findAllRequest() {
        return userMapper.findAllRequest();
    }

    @Override
    public Adopt findAdoptByPetId(int id) {
        return userMapper.findAdoptByPetId(id);
    }

    @Override
    public boolean handleRequest(Adopt adopt) {
        userMapper.handleRequest(adopt);
        if(adopt.getState().equals("领养")){
            userMapper.addAdopt1(adopt);
        }
       return true;
    }

    @Override
    public List<Adopt> findMyAdopt(int id) {
        return userMapper.findMyAdopt(id);
    }

    @Override
    public List<Adopt> findMyRequest(int id) {
        return userMapper.findMyRequest(id);
    }

    @Override
    public List<Adopt> findRepeatRequest(int user_id, int pet_id) {
        return userMapper.findRepeatRequest(user_id,pet_id);
    }
}
