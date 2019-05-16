package com.pastry.mapping;

import com.pastry.pojo.ImExpDistribution;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImExpDistributionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImExpDistribution record);

    int insertSelective(ImExpDistribution record);

    ImExpDistribution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImExpDistribution record);

    int updateByPrimaryKey(ImExpDistribution record);

    List<ImExpDistribution> getAll(@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据ID删除数据
     * @param ids
     * @return
     */
    int deleteBatch(@Param("ids") List<Integer> ids);

    /**
     * 查询总数
     * @return
     */
    int getCount();

}