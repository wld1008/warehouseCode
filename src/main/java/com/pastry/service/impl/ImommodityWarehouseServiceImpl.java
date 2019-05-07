package com.pastry.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.pastry.mapping.ImommodityWarehouseMapper;
import com.pastry.pojo.BaShopDO;
import com.pastry.pojo.ImommodityWarehouse;
import com.pastry.service.ImommodityWarehouseService;
import com.pastry.utils.result.PageResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wulidan on 19/5/7.
 */
@Service
public class ImommodityWarehouseServiceImpl implements ImommodityWarehouseService {
  
    @Resource
    private ImommodityWarehouseMapper imommodityWarehouseMapper;

    @Override
    public PageResult<List<ImommodityWarehouse>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        pageResult.setData(imommodityWarehouseMapper.getAll(startRow, limit));
        pageResult.setCount(imommodityWarehouseMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = imommodityWarehouseMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
}
