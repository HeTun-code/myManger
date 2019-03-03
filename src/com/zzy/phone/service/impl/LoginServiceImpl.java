package com.zzy.phone.service.impl;

import com.zzy.phone.service.LoginService;
import com.zzy.pojo.Dept;
import com.zzy.pojo.User;
import com.zzy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepository userRepository = null;

    public User findUserByLoginNameAndTel(String userName, String telNum) {
        User user = userRepository.getUserByUserLoginNameAndAndTelNum(userName, telNum);
        return user;
    }

    public void changePSW(User user) {
        userRepository.saveAndFlush(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsers(Dept dept) {
        return userRepository.getUsersByDept(dept);
    }


}
