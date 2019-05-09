package com.pastry.service.impl;

import com.pastry.mapping.SeOrderDOMapper;
import com.pastry.pojo.SeOrder;
import com.pastry.service.SeOrderService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wulidan on 19/5/6.
 */
@Service
public class SeOrderServiceImpl implements SeOrderService {
    @Resource
    SeOrderDOMapper seOrderDOMapper;

    @Override
    public PageResult<List<SeOrder>> getAllOrder(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        pageResult.setData(seOrderDOMapper.getAll(startRow, limit));
        pageResult.setCount(seOrderDOMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteOrderById(List<Integer> ids) {
        seOrderDOMapper.deleteBatch(ids);
        return null;
    }
}
