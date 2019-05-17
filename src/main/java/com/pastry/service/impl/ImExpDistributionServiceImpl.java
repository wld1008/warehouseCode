package com.pastry.service.impl;

import com.pastry.mapping.BaShopDOMapper;
import com.pastry.mapping.BaWarehouseMapper;
import com.pastry.mapping.ImExpDistributionMapper;
import com.pastry.pojo.BaShopDO;
import com.pastry.pojo.BaWarehouse;
import com.pastry.pojo.ImExpDistribution;
import com.pastry.service.ImExpDistributionService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulidan on 19/5/11.
 */
@Service
public class ImExpDistributionServiceImpl implements ImExpDistributionService {
    @Resource
    private ImExpDistributionMapper imExpDistributionMapper;
    @Resource
    private BaShopDOMapper baShopDOMapper;
    @Resource
    private BaWarehouseMapper baWarehouseMapper;


    @Override
    public PageResult<List<ImExpDistribution>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<ImExpDistribution> imExpDistributions = imExpDistributionMapper.getAll(startRow, limit);
        if(CollectionUtils.isEmpty(imExpDistributions)) {
            return null;
        }
        List<ImExpDistribution> imExpDistributionList = new ArrayList<>();
        for(ImExpDistribution expDistribution : imExpDistributions) {
            BaWarehouse baWarehouse = baWarehouseMapper.getByCode(expDistribution.getWarehouseCode());
            expDistribution.setWarehouseName(baWarehouse == null ? "" : baWarehouse.getWarehouseName());
            BaShopDO baShopDO = baShopDOMapper.getByCode(expDistribution.getShopCode());
            expDistribution.setShopName(baShopDO == null ? "" : baShopDO.getShopName());
            imExpDistributionList.add(expDistribution);
        }
        pageResult.setData(imExpDistributionList);
        pageResult.setCount(imExpDistributionMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = imExpDistributionMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
    
    @Override
    public PageResult save(ImExpDistribution imExpDistribution) {
        imExpDistributionMapper.insert(userDO);
        return new PageResult();
    }
}
