package com.zzy.phone.controll;


import com.alibaba.fastjson.JSON;
import com.zzy.phone.service.LoginService;
import com.zzy.phone.utils.TokenUtils;
import com.zzy.phone.vo.ConstomUserVo;
import com.zzy.pojo.Dept;
import com.zzy.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

@Controller
@Component
@RequestMapping("login")
public class LoginControll {
    @Autowired
    private LoginService loginService = null;
//    @Autowired
//    private RedisTemplate redisTemplate = null;

    @RequestMapping("getMessage")
    public @ResponseBody
    ConstomUserVo getMessage(@RequestBody User user) {

        User rUser = loginService.findUserByLoginNameAndTel(user.getUserLoginName(), user.getTelNum());
        ConstomUserVo vo = new ConstomUserVo();
        if (null != rUser) {
            // 生成密码
            String psw = (new Random().nextInt(899999) + 100000) + "";
            //记录密码
            rUser.setPassword(psw);
            loginService.changePSW(rUser);
            //发送密码
            BeanUtils.copyProperties(rUser, vo);
            vo.setMsg("获取成功");
            vo.setState(true);
        } else {
            vo.setState(false);
            vo.setMsg("未查找到该用户");
        }
        return vo;
    }

    @RequestMapping("login")
    public @ResponseBody
    ConstomUserVo login(@RequestBody User user,HttpServletResponse response) {
//        ClassPathXmlApplicationContext applicationContextredis=new ClassPathXmlApplicationContext("bean-redis.xml");
//        RedisTemplate redisTemplate = applicationContextredis.getBean(RedisTemplate.class);
        Jedis jedis = new Jedis("47.101.69.67", 6379);
        User rUser = loginService.findUserByLoginNameAndTel(user.getUserLoginName(), user.getTelNum());
        ConstomUserVo vo = new ConstomUserVo();
        if (null != rUser) {
            if (user.getPassword() != null && user.getPassword().equals(rUser.getPassword())) {
                //第一步：生成token对象
                String token = TokenUtils.getCreateToken();
                //第二步：将以  token为key   用户对象的json为值  存储到Redis中去  并设置过期时间
//                redisTemplate.opsForValue().set(token, JSON.toJSONString(rUser),60*60);
                 jedis.set(token, JSON.toJSONString(rUser));
                //第三步：将用户信息和  state  msg 封装成JAVA对象 放到response中去
                vo.setMsg("登陆成功");
                vo.setState(true);
                BeanUtils.copyProperties(rUser, vo);
                //第四步：将token信息 放到response的header中去
                response.setHeader("token", token);
                //第五步返回数据给客户端(JSON)
            } else {
                vo.setState(false);
                vo.setMsg("密码错误");
            }
        } else {
            vo.setState(false);
            vo.setMsg("未查找到该用户");
        }
        return vo;
    }

    @RequestMapping("userInfo")
    public @ResponseBody
    List<User> userInfo() {
        List<User> users = loginService.getUsers();
        ConstomUserVo vo = new ConstomUserVo();
        if (null != users) {
            vo.setMsg("成功");
            vo.setState(true);
        } else {
            vo.setState(false);
            vo.setMsg("未查找到该用户");
        }
        return users;
    }

    @RequestMapping("dept")
    public @ResponseBody
    Dept deptUser(@RequestBody Dept dept) {
        List<User> users = loginService.getUsers(dept);
        ConstomUserVo vo = new ConstomUserVo();
        if (null != users) {
            dept.setUsers(users);
            vo.setMsg("成功");
            vo.setState(true);
        } else {
            vo.setState(false);
            vo.setMsg("未查找到该用户");
        }
        return dept;
    }
}
