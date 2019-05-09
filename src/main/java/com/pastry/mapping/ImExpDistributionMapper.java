package com.pastry.mapping;

import com.pastry.pojo.ImExpDistribution;

public interface ImExpDistributionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImExpDistribution record);

    int insertSelective(ImExpDistribution record);

    ImExpDistribution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImExpDistribution record);

    int updateByPrimaryKey(ImExpDistribution record);
}