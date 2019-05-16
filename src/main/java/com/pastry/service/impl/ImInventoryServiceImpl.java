package com.pastry.service.impl;

import com.pastry.mapping.BaShopDOMapper;
import com.pastry.mapping.BaWarehouseMapper;
import com.pastry.mapping.ImInventoryMapper;
import com.pastry.mapping.ImProductDOMapper;
import com.pastry.pojo.BaShopDO;
import com.pastry.pojo.BaWarehouse;
import com.pastry.pojo.ImInventory;
import com.pastry.pojo.ImProductDO;
import com.pastry.service.ImInventoryService;
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
public class ImInventoryServiceImpl implements ImInventoryService {
  
    @Resource
    private ImInventoryMapper imInventoryMapper;
    @Resource
    private ImProductDOMapper imProductDOMapper;
    @Resource
    private BaShopDOMapper baShopDOMapper;
    @Resource
    private BaWarehouseMapper baWarehouseMapper;

    @Override
    public PageResult<List<ImInventory>> getAll(int page, int limit) {
        PageResult pageResult = new PageResult();
        int startRow = (page - 1) * limit;
        List<ImInventory> imInventories = imInventoryMapper.getAll(startRow, limit);
        if(CollectionUtils.isEmpty(imInventories)){
            return null;
        }
        List<ImInventory> imInventorieList = new ArrayList<>();
        for(ImInventory inventory : imInventories) {
            ImProductDO imProductDO = imProductDOMapper.getByCode(inventory.getProductCode());
            inventory.setProductName(imProductDO == null ? "": imProductDO.getProductName());
            BaShopDO baShopDO = baShopDOMapper.getByCode(inventory.getShopCode());
            inventory.setShopName(baShopDO.getShopName());
            BaWarehouse baWarehouse = baWarehouseMapper.getByCode(inventory.getWarehouseCode());
            inventory.setWarehouseName(baWarehouse == null ? "" : baWarehouse.getWarehouseName());
            imInventorieList.add(inventory);
        }
        pageResult.setData(imInventorieList);
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
