package com.hourfun.auth.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReidsTests {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;
//    private final RedisDataRepository<String, Object> redisDataRepository;

    @Test
    public void 레디스_pub_sub_test() {
//        redisDataRepository.setRedisTemplate(redisTemplate);
        redisTemplate.convertAndSend("test1", "가라");
        redisTemplate.convertAndSend("test2", "와라");
    }
}
