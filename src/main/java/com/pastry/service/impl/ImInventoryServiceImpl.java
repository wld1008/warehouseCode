package com.pastry.service.impl;

/**
 * Created by wulidan on 19/5/7.
 */
@Service
public class ImInventoryServiceImpl {
  
    @Resource
    private ImInventoryMapper imInventoryMapper;

    @Override
    public PageResult<List<ImInventory>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        pageResult.setData(imInventoryMapper.getAll(startRow, limit));
        pageResult.setCount(imInventoryMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = imInventoryMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
}
