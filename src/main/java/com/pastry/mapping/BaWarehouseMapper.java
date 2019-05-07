package com.pastry.mapping;

import com.pastry.pojo.BaWarehouse;

public interface BaWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaWarehouse record);

    int insertSelective(BaWarehouse record);

    BaWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaWarehouse record);

    int updateByPrimaryKey(BaWarehouse record);
    
    List<BaWarehouse> getAll(@Param("start") int start, @Param("limit") int limit);

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
