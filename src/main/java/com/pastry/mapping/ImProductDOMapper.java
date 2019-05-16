package com.pastry.mapping;

import com.pastry.pojo.ImProductDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImProductDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImProductDO record);

    int insertSelective(ImProductDO record);

    ImProductDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImProductDO record);

    int updateByPrimaryKey(ImProductDO record);
    
     List<ImProductDO> getAll(@Param("start") int start, @Param("limit") int limit);

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

    /**
     * 根据商品编码查询商品信息
     * @param productCode
     * @return
     */
    ImProductDO getByCode(@Param("productCode") String productCode);
}
