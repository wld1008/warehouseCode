package com.pastry.service.impl;

import com.pastry.mapping.ImDeliveryTrackingMapper;
import com.pastry.pojo.ImDeliveryTracking;
import com.pastry.service.ImDeliveryTrackingService;
import com.pastry.utils.DeliveryEnum;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulidan on 19/5/7.
 */
@Service
public class ImDeliveryTrackingServiceImpl implements ImDeliveryTrackingService {
    @Resource
    private ImDeliveryTrackingMapper imDeliveryTrackingMapper;

    @Override
    public PageResult<List<ImDeliveryTracking>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<ImDeliveryTracking> list = imDeliveryTrackingMapper.getAll(startRow, limit);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ImDeliveryTracking> deliveryTrackings = new ArrayList<>();
        for (ImDeliveryTracking deliveryTracking : list) {
            deliveryTracking.setDesc(DeliveryEnum.getDesc(deliveryTracking.getStatus()));
            deliveryTracking.setOperateTime(sdf.format(deliveryTracking.getCreateTime()));
            deliveryTrackings.add(deliveryTracking);
        }
        pageResult.setData(deliveryTrackings);
        pageResult.setCount(imDeliveryTrackingMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = imDeliveryTrackingMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
    
    @Override
    public PageResult save(ImDeliveryTracking imDeliveryTracking) {
        imDeliveryTrackingMapper.insert(imDeliveryTracking);
        return new PageResult();
    }
}
