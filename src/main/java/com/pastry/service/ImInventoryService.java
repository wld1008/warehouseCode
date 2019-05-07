package com.pastry.service;

import com.pastry.pojo.ImInventory;
import com.pastry.utils.result.PageResult;

import java.util.List;

/**
 * Created by wulidan on 19/5/7.
 */
public interface ImInventoryService {
   /**
     * 查询所有信息
     * @return
     */
    PageResult<List<ImInventory>> getAll(int page, int limit);

    /**
     * 根据ID批量删除
     * @param ids
     * @return
     */
    PageResult deleteBatch(List<Integer> ids);
}
