package com.example.service;

import com.example.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/11
 */
public interface UserService {

    User save(User user);

    User findById(Long id);

    void deleteFromCache(Long id);

    PageInfo<User> listPage(Long id );

    void update(User user)throws Exception;
}
