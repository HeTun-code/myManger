import com.alibaba.fastjson.JSON;
import com.zzy.phone.utils.TokenUtils;
import com.zzy.pojo.User;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {
    @Test
    public void Test() {
        User user = new User();
        user.setUserLoginName("Zzy");
        user.setTelNum("123");
        user.setPassword("123");

        Jedis jedis = new Jedis("47.101.69.67", 6379);

        String s = JSON.toJSONString(user);
        jedis.set("pppxxx", s);



        String login = TokenUtils.isLogin("pppxxx");
        System.out.println(login);
    }
}
