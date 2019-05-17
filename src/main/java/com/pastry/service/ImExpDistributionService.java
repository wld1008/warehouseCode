package com.pastry.service;

import com.pastry.pojo.ImExpDistribution;
import com.pastry.utils.result.PageResult;

import java.util.List;

/**
 * Created by wulidan on 19/5/11.
 */
public interface ImExpDistributionService {

    /**
     * 查询所有信息
     * @return
     */
    PageResult<List<ImExpDistribution>> getAll(int page, int limit);

    /**
     * 根据ID批量删除
     * @param ids
     * @return
     */
    PageResult deleteBatch(List<Integer> ids);
    
    PageResult save (ImExpDistribution imExpDistribution);
}
