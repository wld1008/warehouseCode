package com.pastry.mapping;

import com.pastry.pojo.ImDeliveryTracking;

public interface ImDeliveryTrackingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImDeliveryTracking record);

    int insertSelective(ImDeliveryTracking record);

    ImDeliveryTracking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImDeliveryTracking record);

    int updateByPrimaryKey(ImDeliveryTracking record);
}