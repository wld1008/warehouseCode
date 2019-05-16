package com.pastry.mapping;


import com.pastry.pojo.BaShopDO;
import com.pastry.pojo.ImProductDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaShopDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaShopDO record);

    int insertSelective(BaShopDO record);

    BaShopDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaShopDO record);

    int updateByPrimaryKey(BaShopDO record);


    //获取用户名单
    List<BaShopDO> getAll(@Param("start") int start, @Param("limit") int limit);

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
     * 根据门店编码查询信息
     * @param shopCode
     * @return
     */
    BaShopDO getByCode(@Param("shopCode") String shopCode);
}