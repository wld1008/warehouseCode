package com.pastry.mapping;

import com.pastry.pojo.BaWarehouse;

public interface BaWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaWarehouse record);

    int insertSelective(BaWarehouse record);

    BaWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaWarehouse record);

    int updateByPrimaryKey(BaWarehouse record);
}