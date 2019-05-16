package com.pastry.mapping;

import com.pastry.pojo.ImCommodityWarehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImCommodityWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImCommodityWarehouse record);

    int insertSelective(ImCommodityWarehouse record);

    ImCommodityWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImCommodityWarehouse record);

    int updateByPrimaryKey(ImCommodityWarehouse record);
    
     List<ImCommodityWarehouse> getAll(@Param("start") int start, @Param("limit") int limit);

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
