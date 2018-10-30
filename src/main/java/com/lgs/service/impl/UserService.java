package com.lgs.service.impl;

import com.lgs.dao.UserMapper;
import com.lgs.pojo.User;
import com.lgs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("IUserService")
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    public User findUser(String username) {
        return userMapper.selectByUsername(username);
    }

    public Set<String> findRoles(String username) {
        return userMapper.selectRoles(username);
    }

    public Set<String> findPermissions(String username) {
        return userMapper.selectPermissions(username);
    }
}
