package com.pastry.mapping;


import com.pastry.pojo.SeOrderDO;

public interface SeOrderDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeOrderDO record);

    int insertSelective(SeOrderDO record);

    SeOrderDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeOrderDO record);

    int updateByPrimaryKey(SeOrderDO record);
    
      List<SeOrderDO> getAll(@Param("start") int start, @Param("limit") int limit);

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
