package com.pastry.mapping;


import com.pastry.pojo.BaShopDO;

public interface BaShopDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaShopDO record);

    int insertSelective(BaShopDO record);

    BaShopDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaShopDO record);

    int updateByPrimaryKey(BaShopDO record);
}