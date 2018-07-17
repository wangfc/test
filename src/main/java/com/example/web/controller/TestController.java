package com.example.web.controller;

import com.alibaba.fastjson.JSON;
import com.example.dao.UserDao;
import com.example.service.UserService;
import com.example.web.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@RestController
@Slf4j
@Api(" testController api ...  ")
public class TestController {

    @Resource
    UserDao userDao;

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public com.example.entity.User hello(HttpSession session){
      /*  User user = new User();
        user.setName("张12df4");*/

/*        com.example.entity.User u = new com.example.entity.User();
        u.setName("张三");
        userDao.save(u);*/
        com.example.entity.User user = userDao.findById(1L).get();
        session.setAttribute("userInfo",user);
        log.debug("seesionId:{},userInfo:{}" , session.getId(),JSON.toJSON(session.getAttribute("userInfo")));
        return user;
    }

    @RequestMapping("/user")
    public User user(){
        User user = new User();
        user.setName("cc");
        return user;
    }

    @ApiOperation(value = "更新用户信息",notes = "更新用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "user",value = "用户信息",dataType = "User",required = true,paramType = "body")})
    @RequestMapping(value = "/user/update" ,method = RequestMethod.POST)
    public String update(@RequestBody  com.example.entity.User user){
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(user);
    }

}
