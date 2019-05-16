package com.pastry.service.impl;


import com.pastry.mapping.BaShopDOMapper;
import com.pastry.mapping.BaWarehouseMapper;
import com.pastry.mapping.ImCommodityWarehouseMapper;
import com.pastry.mapping.ImProductDOMapper;
import com.pastry.pojo.BaShopDO;
import com.pastry.pojo.BaWarehouse;
import com.pastry.pojo.ImCommodityWarehouse;
import com.pastry.pojo.ImProductDO;
import com.pastry.service.ImCommodityWarehouseService;
import com.pastry.utils.CommodityEnum;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulidan on 19/5/7.
 */
@Service
public class ImCommodityWarehouseServiceImpl implements ImCommodityWarehouseService {
  
    @Resource
    private ImCommodityWarehouseMapper imCommodityWarehouseMapper;
    @Resource
    private ImProductDOMapper imProductDOMapper;
    @Resource
    private BaShopDOMapper baShopDOMapper;
    @Resource
    private BaWarehouseMapper baWarehouseMapper;

    @Override
    public PageResult<List<ImCommodityWarehouse>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<ImCommodityWarehouse> commodityWarehouses = imCommodityWarehouseMapper.getAll(startRow, limit);
        if(CollectionUtils.isEmpty(commodityWarehouses)) {
            return null;
        }
        List<ImCommodityWarehouse> commodityWarehouseList = new ArrayList<>();
        for(ImCommodityWarehouse commodityWarehouse : commodityWarehouses) {
            BaWarehouse baWarehouse = baWarehouseMapper.getByCode(commodityWarehouse.getWarehouseCode());
            commodityWarehouse.setWarehouseName(baWarehouse == null ? "" : baWarehouse.getWarehouseName());
            ImProductDO imProductDO = imProductDOMapper.getByCode(commodityWarehouse.getProductCode());
            commodityWarehouse.setProductName(imProductDO == null ? "" : imProductDO.getProductName());
            BaShopDO baShopDO = baShopDOMapper.getByCode(commodityWarehouse.getShopCode());
            commodityWarehouse.setShopName(baShopDO == null ? "" : baShopDO.getShopName());
            commodityWarehouse.setDesc(CommodityEnum.getDesc(commodityWarehouse.getStatus()));
            commodityWarehouseList.add(commodityWarehouse);
        }
        pageResult.setData(commodityWarehouseList);
        pageResult.setCount(imCommodityWarehouseMapper.getCount());
        return pageResult;
    }

    @Override
    public PageResult deleteBatch(List<Integer> ids) {
        PageResult pageResult = new PageResult();
        int val = imCommodityWarehouseMapper.deleteBatch(ids);
        if(val == 0) {
            pageResult.setCode(1001);
            pageResult.setMsg("没有数据");
        }
        return pageResult;
    }
}
