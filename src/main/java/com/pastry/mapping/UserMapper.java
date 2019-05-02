package com.pastry.mapping;

import com.pastry.pojo.User;

import java.util.List;

/**
 * Created by wulidan on 19/2/20.
 */
public interface UserMapper {

    //获取用户名单
    public List<User> getUser() throws Exception;
    //根据id删除用户
    public void deleteUser(int id)throws Exception;
}
