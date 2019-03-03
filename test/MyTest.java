
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyTest {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Test
    public void save() {
        // redisTemplate.opsForValue().set(key,val);

        redisTemplate.opsForValue().set("13","123");


//        redisTemplate.opsForZSet():    //专门操作sorted set的
//
//        redisTemplate.opsForList();    //这个是专门操作List这种类型的
//
//        redisTemplate.opsForSet();     //这个是专门用来操作set的
//
//        redisTemplate.opsForHash();    //这个是专门用来操作hash这个结构的

    }

}

