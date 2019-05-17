package com.pastry.service;

import com.pastry.pojo.UserDO;
import com.pastry.utils.result.PageResult;

import java.util.List;

/**
 * Created by wulidan on 19/5/3.
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    PageResult<List<UserDO>> getAllUser(int page, int limit);

    /**
     * 根据ID批量删除用户信息
     * @param ids
     * @return
     */
    PageResult deleteUserById(List<Integer> ids);

    PageResult save (UserDO userDO);
}
