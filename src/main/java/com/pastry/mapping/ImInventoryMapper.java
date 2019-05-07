package com.pastry.mapping;

import com.pastry.pojo.ImInventory;

public interface ImInventoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImInventory record);

    int insertSelective(ImInventory record);

    ImInventory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImInventory record);

    int updateByPrimaryKey(ImInventory record);
    
    
    List<ImInventory> getAll(@Param("start") int start, @Param("limit") int limit);

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
