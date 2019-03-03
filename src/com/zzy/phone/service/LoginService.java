package com.zzy.phone.service;

import com.zzy.pojo.Dept;
import com.zzy.pojo.User;

import java.util.List;

public interface LoginService {
    User findUserByLoginNameAndTel(String userName,String telNum);

    void changePSW(User user);

    List<User> getUsers();

    List<User> getUsers(Dept dept);
}
