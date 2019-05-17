package com.pastry.service.impl;

import com.pastry.mapping.BaShopDOMapper;
import com.pastry.pojo.BaShopDO;
import com.pastry.service.BaShopService;
import com.pastry.utils.StatusEnum;
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
public class BaShopServiceImpl implements BaShopService {

    @Resource
    private BaShopDOMapper baShopDOMapper;

    @Override
    public PageResult<List<BaShopDO>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<BaShopDO> shopDOList =  baShopDOMapper.getAll(startRow, limit);
        List<BaShopDO> newShopDOList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(shopDOList)) {
            for (BaShopDO baShopDO : shopDOList) {
                baShopDO.setStatusDesc(StatusEnum.getDesc(baShopDO.getStatus()));
                newShopDOList.add(baShopDO);
            }
        }
        pageResult.setData(newShopDOList);
        pageResult.setCount(baShopDOMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = baShopDOMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
    
    @Override
    public PageResult save(BaShopDO baShopDO) {
        baShopDOMapper.insert(baShopDO);
        return new PageResult();
    }
}
