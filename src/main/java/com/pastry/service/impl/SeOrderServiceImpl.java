package com.pastry.service.impl;

import com.pastry.mapping.ImProductDOMapper;
import com.pastry.mapping.SeOrderMapper;
import com.pastry.pojo.ImProductDO;
import com.pastry.pojo.SeOrder;
import com.pastry.service.SeOrderService;
import com.pastry.utils.OrderStatusEnum;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulidan on 19/5/6.
 */
@Service
public class SeOrderServiceImpl implements SeOrderService {
    @Resource
    SeOrderMapper seOrderDOMapper;
    @Resource
    private ImProductDOMapper imProductDOMapper;

    @Override
    public PageResult<List<SeOrder>> getAllOrder(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<SeOrder> orders = seOrderDOMapper.getAll(startRow, limit);
        if(CollectionUtils.isEmpty(orders)) {
            return null;
        }
        List<SeOrder> orderList = new ArrayList<>();
        for(SeOrder order : orders) {
            ImProductDO productDO = imProductDOMapper.getByCode(order.getProductCode());
            order.setProductName(productDO == null ? "" : productDO.getProductName());
            order.setDesc(productDO == null ? "" : OrderStatusEnum.getDesc(order.getOrderStatus()));
            orderList.add(order);
        }
        pageResult.setData(orderList);
        pageResult.setCount(seOrderDOMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteOrderById(List<Integer> ids) {
        seOrderDOMapper.deleteBatch(ids);
        return null;
    }
    
    @Override
    public PageResult save(SeOrder seOrder) {
        seOrderDOMapper.insert(userDO);
        return new PageResult();
    }
}
