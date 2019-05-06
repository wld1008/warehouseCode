package com.pastry.mapping;

import com.pastry.pojo.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wulidan on 19/2/20.
 */
@Component
public interface UserMapper {

    //获取用户名单
     List<UserDO> getUser(@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据ID删除数据
     * @param ids
     * @return
     */
    int deleteUser(@Param("ids") List<Integer> ids);

    /**
     * 查询总数
     * @return
     */
    int getCount();
    /**
     * 新增用户信息
     * @param userDO
     * @return
     */
    int insert(UserDO userDO);
}
