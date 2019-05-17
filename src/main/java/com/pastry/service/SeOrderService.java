package com.pastry.service;

import com.pastry.pojo.SeOrder;
import com.pastry.utils.result.PageResult;

import java.util.List;

/**
 * Created by wulidan on 19/5/6.
 */
public interface SeOrderService {
    /**
     * 查询所有订单信息
     * @return
     */
    PageResult<List<SeOrder>> getAllOrder(int page, int limit);

    /**
     * 根据快递公司编码和快递单号查询物流跟踪信息
     * @param expCode
     * @param expNum
     * @return
     */
    boolean queryTrackByExp(String expCode, String expNum) throws Exception;

    /**
     * 根据ID批量删除用户信息
     * @param ids
     * @return
     */
    PageResult deleteOrderById(List<Integer> ids);
    
    PageResult save (SeOrder seOrder);
}
