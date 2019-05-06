package com.pastry.mapper;

import com.pastry.ApplicationController;
import com.pastry.mapping.UserMapper;
import com.pastry.pojo.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by wulidan on 19/5/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationController.class)
public class UserDOTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void aa() {
    }

    @Test
    public void insert() {
        for(int i =0 ; i< 50 ; i++) {
            UserDO userDO = new UserDO();
            userDO.setUserName("球球"+i+"号");
            userDO.setPassword("123456"+i);
            userDO.setAge(1);
            userDO.setEmail("qiuqiu1.qq.com");
            userDO.setMobile("15968884502");
            userDO.setSex(1);
            userMapper.insert(userDO);
        }

    }
}
