package com.pastry.mapping;

import com.pastry.pojo.ImInventory;

public interface ImInventoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImInventory record);

    int insertSelective(ImInventory record);

    ImInventory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImInventory record);

    int updateByPrimaryKey(ImInventory record);
}