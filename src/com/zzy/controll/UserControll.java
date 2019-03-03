package com.zzy.controll;


import com.zzy.pojo.Mission;
import com.zzy.pojo.User;
import com.zzy.service.MissionService;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserControll {
    @Autowired
    private UserService userService = null;
    @Autowired
    private MissionService missionService = null;

    @RequestMapping("findUserAll")
    public  String findUserAll(HttpServletRequest request) {
        List<User>  users =  userService.gerUserAll();
        request.setAttribute("users",users);
        return "user/user";
    }
    @RequestMapping("findUserAllTest")
    public  @ResponseBody List<User> findUserAllTest() {
        List<User>  users =  userService.gerUserAll();
        return users;
    }
    @RequestMapping("showAddUser")
    public String showAddUser(HttpServletRequest request) {
        List<Mission> missions = missionService.getMissionAll();
        request.setAttribute("missions",missions);
        return "user/showAddUser";
    }
    @RequestMapping("selectUser")
    public String selectUser(User user,HttpServletRequest request) {
        List<User> usersByVo = userService.getUsersByVo(user);
        request.setAttribute("users",usersByVo);
        return "user/user";
    }
    @RequestMapping("selectUserTest")
    public @ResponseBody List<User> selectUserTest(@RequestBody User user) {
        List<User> usersByVo = userService.getUsersByVo(user);
        return usersByVo;
    }
    @RequestMapping("test")
    public @ResponseBody List<User> Test(@RequestBody User user) {
        System.out.println(user);
        List<User> users = userService.getUsersByVo(user);
        return users;
    }

    @RequestMapping("delUser")
    public String selectUser(Integer userId) {
        userService.delUserById(userId);
        return "user/user";
    }

    @RequestMapping("changeUser")
    public String changeUser(Integer userId,HttpServletRequest request) {
        User usersById = userService.gerUserById(userId);
        request.setAttribute("user",usersById);
        return "user/showUpdateUser";
    }

    @RequestMapping("updataUser")
    public String updataUser(User user) {
        userService.updataUser(user);
        return "user/user";
    }
    @RequestMapping("addUser")
    public String addUser(User user) {
        user.setMission(missionService.getMissionById(user.getMission().getMissionId()));
        userService.addUser(user);
        return "user/user";
    }

}
