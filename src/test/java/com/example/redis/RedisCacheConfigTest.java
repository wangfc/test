package com.example.redis;

import com.example.BaseTest;
import com.example.dao.UserDao;
import com.example.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
public class RedisCacheConfigTest extends BaseTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test(){
        System.out.println(redisTemplate.opsForValue().get("a"));
        User user = userDao.findById(1L).get();
        redisTemplate.opsForValue().set("a",user);
        System.out.println(redisTemplate.opsForValue().get("a"));
    }

    @Test
    public void testCache(){

    }

    @Test
    public void test1(){
        String key = "wung:ha:sessions:9b55e190-862b-428b-a1f9-86a74a54a6c4";

    }
}