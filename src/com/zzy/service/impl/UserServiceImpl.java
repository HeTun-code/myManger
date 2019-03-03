package com.zzy.service.impl;

import com.zzy.pojo.User;
import com.zzy.repository.UserRepository;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
    @Autowired
    UserRepository userRepository = null;

    public List<User> gerUserAll() {
        return userRepository.findAll();
    }

    public List<User> getUsersByVo(User user) {
        List<User> users = userRepository.getUsersByVo(user.getUserName(),user.getTelNum());
        return users;
    }

    public void delUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public User gerUserById(Integer id) {
        return userRepository.getUsersByUserId(id);
    }

    public void updataUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public void addUser(User user) {
        userRepository.saveAndFlush(user);
    }
}
