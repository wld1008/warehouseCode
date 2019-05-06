package com.pastry.service.impl;

import com.pastry.mapping.UserMapper;
import com.pastry.pojo.UserDO;
import com.pastry.service.UserService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
        pageResult.setData(CollectionUtils.isEmpty(users) ? null : users);
        return pageResult;
    }

    @Override
    public PageResult deleteUserById(List<Integer> ids) {
        int val = userMapper.deleteUser(ids);
        PageResult pageResult = new PageResult();
        return pageResult;
    }
}
