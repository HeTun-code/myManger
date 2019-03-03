package com.zzy.service;

import com.zzy.pojo.User;

import java.util.List;

/**
 * @author 麋鹿君
 */
public interface UserService{
    List<User> gerUserAll();
    List<User> getUsersByVo(User user);
    void delUserById(Integer id);
    User gerUserById(Integer id);
    void updataUser(User user);
    void addUser(User user);
}
