package com.lgs.service;

import com.lgs.pojo.User;

import java.util.Set;

public interface IUserService {
    User findUser(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
