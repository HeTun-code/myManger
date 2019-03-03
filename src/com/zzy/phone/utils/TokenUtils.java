package com.zzy.phone.utils;


import com.alibaba.fastjson.JSON;
import com.zzy.pojo.User;
import com.zzy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.UUID;

public class TokenUtils {

    public static String getCreateToken() {
        String str = UUID.randomUUID().toString().replaceAll("-", "");
        return str.trim();
    }

    public static String isLogin(String token) {
        ClassPathXmlApplicationContext applicationContextbase=new ClassPathXmlApplicationContext("bean-base.xml");
//        ClassPathXmlApplicationContext applicationContextredis=new ClassPathXmlApplicationContext("bean-redis.xml");
//        RedisTemplate redisTemplate = applicationContextredis.getBean(RedisTemplate.class);
        UserRepository userRepository=applicationContextbase.getBean(UserRepository.class);
        Jedis jedis = new Jedis("47.101.69.67", 6379);
        String s = null;
        if (token != null) {

            s = jedis.get(token);
//           s = (String)redisTemplate.opsForValue().get(token);


        }
        if (null != s) {
            User user = JSON.parseObject(s, User.class);
            User userQuery = userRepository.getUserByUserLoginNameAndAndTelNumAndPassword(user.getUserLoginName(), user.getTelNum(), user.getPassword());
            if (null != userQuery) {
                String newToken = getCreateToken();
//               redisTemplate.delete(token);
//               redisTemplate.opsForValue().set(newToken,s,60*60);
                jedis.del(token);
                jedis.set(newToken, s);
                return newToken;
            } else {
                return null;
            }
        }
        return null;
    }
}
