package com.pastry.mapping;

import com.pastry.pojo.ImommodityWarehouse;

public interface ImommodityWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImommodityWarehouse record);

    int insertSelective(ImommodityWarehouse record);

    ImommodityWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImommodityWarehouse record);

    int updateByPrimaryKey(ImommodityWarehouse record);
    
     List<ImommodityWarehouse> getAll(@Param("start") int start, @Param("limit") int limit);

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
