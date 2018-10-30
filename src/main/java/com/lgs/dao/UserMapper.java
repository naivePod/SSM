package com.lgs.dao;

import com.lgs.pojo.User;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    Set<String> selectRoles(String username);

    Set<String> selectPermissions(String username);


    int updateByPrimaryKey(User record);
}