package com.pastry.service.impl;

import com.pastry.mapping.UserMapper;
import com.pastry.pojo.UserDO;
import com.pastry.service.UserService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wulidan on 19/5/3.
 */
@Service
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public PageResult<List<UserDO>> getAllUser(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<UserDO> users = userMapper.getUser(startRow, limit);
        pageResult.setCount(userMapper.getCount());
        if(CollectionUtils.isEmpty(users)){
            return null;
        }

        List<UserDO> userDOs = new ArrayList<>();
        for (UserDO userDO : users) {
            String password = userDO.getPassword();
            userDO.setPassword(password.replace(password.substring(1,password.length()),"**"));
            String mobile = userDO.getMobile();
            userDO.setMobile(mobile.replace(mobile.substring(3,mobile.length()-3),"****"));
        }

        pageResult.setData(CollectionUtils.isEmpty(users) ? null : users);
        return pageResult;
    }

    @Override
    public PageResult deleteUserById(List<Integer> ids) {
        int val = userMapper.deleteUser(ids);
        PageResult pageResult = new PageResult();
        return pageResult;
    }

    @Override
    public PageResult save(UserDO userDO) {
        userMapper.insert(userDO);
        return new PageResult();
    }

}
