package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Cacheable(cacheNames = {"user"} , key = "'userId'+#id")
    @Override
    public User findById(Long id) {
        log.info("缓存中不存在，从数据库中获取user数据，userId:{}",id);
        return userDao.findById(id).get();
    }

    @CacheEvict(cacheNames = {"user"}, key = "'userId'+#id")
    @Override
    public void deleteFromCache(Long id) {
        log.info("从数据库中删除数据，，userId:{}",id);
    }

    @Override
    @Transactional
    public User save(User user) {
        User u = userDao.save(user);
        return u;
    }

    @Override
//    @Transactional
    public PageInfo<User> listPage(Long id) {
       /* User user = userDao.findById(1L).get();
        user.setName("aa");
        userMapper.update(user);


        user.setAge(11);
        userDao.save(user);*/

        PageHelper.startPage(1,4);
        List<User> list = userMapper.list(new User());
//        User user = userMapper.findById(1L);
        log.info("us=={}" , list);
        return new PageInfo<>(list);
    }

    @Transactional
    @Override
    public void update(User user) throws Exception{
        userMapper.update(user);

        user.setAge(44);
        userDao.save(user);
    }
}
