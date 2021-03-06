package com.pastry.service.impl;

import com.pastry.mapping.ImProductDOMapper;
import com.pastry.pojo.ImProductDO;
import com.pastry.service.ImProductService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wulidan on 19/5/6.
 */
@Service
public class ImProductServiceImpl implements ImProductService {

    @Resource
    private ImProductDOMapper imProductDOMapper;

    @Override
    public PageResult<List<ImProductDO>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        pageResult.setData(imProductDOMapper.getAll(startRow, limit));
        pageResult.setCount(imProductDOMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = imProductDOMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
    
    @Override
    public PageResult save(ImProductDO imProductDO) {
        imProductDOMapper.insert(imProductDO);
        return new PageResult();
    }
}
