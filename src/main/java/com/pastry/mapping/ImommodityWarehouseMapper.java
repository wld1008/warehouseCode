package com.pastry.mapping;

import com.pastry.pojo.ImommodityWarehouse;

public interface ImommodityWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImommodityWarehouse record);

    int insertSelective(ImommodityWarehouse record);

    ImommodityWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImommodityWarehouse record);

    int updateByPrimaryKey(ImommodityWarehouse record);
}