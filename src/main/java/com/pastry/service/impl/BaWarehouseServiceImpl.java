package com.pastry.service.impl;

import com.pastry.mapping.BaWarehouseMapper;
import com.pastry.pojo.BaWarehouse;
import com.pastry.service.BaWarehouseService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wulidan on 19/5/7.
 */
@Service
public class BaWarehouseServiceImpl implements BaWarehouseService{
  
  @Resource
    private BaWarehouseMapper baWarehouseMapper;

    @Override
    public PageResult<List<BaWarehouse>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        pageResult.setData(baWarehouseMapper.getAll(startRow, limit));
        pageResult.setCount(baWarehouseMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = baWarehouseMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
}
