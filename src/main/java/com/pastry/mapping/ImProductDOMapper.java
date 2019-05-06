package com.pastry.mapping;

import com.pastry.pojo.ImProductDO;

public interface ImProductDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImProductDO record);

    int insertSelective(ImProductDO record);

    ImProductDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImProductDO record);

    int updateByPrimaryKey(ImProductDO record);
}