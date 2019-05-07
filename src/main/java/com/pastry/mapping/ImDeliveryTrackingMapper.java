package com.pastry.mapping;

import com.pastry.pojo.ImDeliveryTracking;

public interface ImDeliveryTrackingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImDeliveryTracking record);

    int insertSelective(ImDeliveryTracking record);

    ImDeliveryTracking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImDeliveryTracking record);

    int updateByPrimaryKey(ImDeliveryTracking record);

    List<ImDeliveryTracking> getAll(@Param("start") int start, @Param("limit") int limit);

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
