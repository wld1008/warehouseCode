package com.pastry.service.impl;

/**
 * Created by wulidan on 19/5/7.
 */
@Sevice
public class ImDeliveryTrackingServiceImpl {
    @Resource
    private ImDeliveryTrackingMapper imDeliveryTrackingMapper;

    @Override
    public PageResult<List<ImDeliveryTracking>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        pageResult.setData(imDeliveryTrackingMapper.getAll(startRow, limit));
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
}
