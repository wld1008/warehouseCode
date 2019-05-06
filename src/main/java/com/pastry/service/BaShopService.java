package com.pastry.service;

import com.pastry.pojo.BaShopDO;
import com.pastry.utils.result.PageResult;

import java.util.List;

/**
 * Created by wulidan on 19/5/6.
 */
public interface BaShopService {

    /**
     * 查询所有商家信息
     * @return
     */
    PageResult<List<BaShopDO>> getAll(int page, int limit);

    /**
     * 根据ID批量删除
     * @param ids
     * @return
     */
    PageResult deleteBatch(List<Integer> ids);
}
