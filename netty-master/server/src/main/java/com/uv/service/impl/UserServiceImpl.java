package com.uv.service.impl;

import com.uv.entity.User;
import com.uv.mapper.UserMapper;
import com.uv.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        System.out.println("查询数据库");
        return userMapper.selectAll();
    }



    @Override
    public int insertUser() {
        System.out.println("写入数据库");
        return userMapper.insertUser();}

    @Override
    public String insertContent(String content) {
        System.out.println("写入数据库");
        return userMapper.insertContent(content);
    }

}
