package com.uv.service;

import com.uv.entity.User;

import java.util.List;

/**
 * @author zhihang.yzh
 */
public interface UserService {
    /**
     * 获取所有数据
     * @return
     */
    List<User> selectAll();

    int insertUser();

    String insertContent(String content);
}
