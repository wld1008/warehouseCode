package com.pastry.controller;

import com.pastry.pojo.ImCommodityWarehouse;
import com.pastry.pojo.ImExpDistribution;
import com.pastry.service.ImCommodityWarehouseService;
import com.pastry.service.ImExpDistributionService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wulidan on 19/5/11.
 */
@Controller
@RequestMapping("/distribution")
public class ImExpDistributionController {
    @Resource
    private ImExpDistributionService imExpDistributionService;

    @RequestMapping("/list")
    public String queryList(HttpServletRequest request, HttpServletResponse response) {
        return "/distribution/list";
    }

    @ResponseBody
    @RequestMapping("/listData")
    public PageResult<List<ImExpDistribution>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return imExpDistributionService.getAll(page, limit);
    }
    
    @ResponseBody
    @RequestMapping("/delete")
    public PageResult delete(@RequestParam("ids") String ids) {
        System.out.println(ids);
        return imExpDistributionService.deleteBatch(Arrays.asList(Integer.parseInt(ids)));
    }

    @RequestMapping("/save")
    public PageResult save(@RequestBody ImExpDistribution imExpDistribution) {
        return imExpDistributionService.save(imExpDistribution);
    }

}
