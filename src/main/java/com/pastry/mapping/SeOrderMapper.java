package com.pastry.mapping;


import com.pastry.pojo.SeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeOrder record);

    int insertSelective(SeOrder record);

    SeOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeOrder record);

    int updateByPrimaryKey(SeOrder record);
    
      List<SeOrder> getAll(@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据ID删除数据
     * @param ids
     * @return
     */
    int deleteBatch(@Param("ids") List<Integer> ids);

    /**
     * 查询总数
     * @return
     */
    int getCount();
}
