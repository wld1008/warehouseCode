package com.pastry.service;

/**
 * Created by wulidan on 19/5/7.
 */
public interface ImommodityWarehouseService {
   /**
     * 查询所有信息
     * @return
     */
    PageResult<List<ImommodityWarehouse>> getAll(int page, int limit);

    /**
     * 根据ID批量删除
     * @param ids
     * @return
     */
    PageResult deleteBatch(List<Integer> ids);
}
