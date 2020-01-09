package com.uv.mapper;

import com.uv.entity.User;

import java.util.List;

/**
 * @author zhihang.yzh
 */
//@Repository
public interface UserMapper {

    /**
     * @return
     *
     */
    List<User> selectAll();

    /**
     *
     * @param
     */
    int insertUser();

    String insertContent(String content);
}
