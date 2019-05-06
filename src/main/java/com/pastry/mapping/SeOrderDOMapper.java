package com.pastry.mapping;


import com.pastry.pojo.SeOrderDO;

public interface SeOrderDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeOrderDO record);

    int insertSelective(SeOrderDO record);

    SeOrderDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeOrderDO record);

    int updateByPrimaryKey(SeOrderDO record);
}