package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/12
 */
@Repository
public interface UserMapper {

//    @Select("select * from user where id = #{id}")
    User findById(Long id );

    List<User> list(User user);

    @Update("update user set name = #{name} where id = #{id} ")
    Integer update(User user);
}
