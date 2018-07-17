package com.example.dao;

import com.example.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Repository
public interface UserDao extends PagingAndSortingRepository<User,Long> {

    User findByName(String name);

    List<User> findByAgeBetween(Integer start, Integer end, Sort sort);
}
