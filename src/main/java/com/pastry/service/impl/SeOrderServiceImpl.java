package com.pastry.service.impl;

import com.pastry.service.SeOrderService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wulidan on 19/5/6.
 */
@Service
public class SeOrderServiceImpl implements SeOrderService {
    @Override
    public PageResult<List<SeOrderService>> getAllOrder(int page, int limit) {
        return null;
    }

    @Override
    public PageResult deleteOrderById(List<Integer> ids) {
        return null;
    }
}
