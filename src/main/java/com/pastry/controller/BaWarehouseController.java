package com.pastry.controller;

import com.pastry.pojo.BaShopDO;
import com.pastry.pojo.BaWarehouse;
import com.pastry.service.BaWarehouseService;
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
 * Created by wulidan on 19/5/7.
 */
@Controller
@RequestMapping("/baWarehouse")
public class BaWarehouseController {
  
  @Resource
  private BaWarehouseService baWarehouseService;
  
  @RequestMapping("/list")
  public String queryList(HttpServletRequest request, HttpServletResponse response) {
      return "/stock/list";
  }
  
   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<BaWarehouse>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
      return baWarehouseService.getAll(page, limit);
   }
  
    @ResponseBody
    @RequestMapping("/delete")
    public PageResult delete(@RequestParam("ids") String ids) {
        System.out.println(ids);
        return baWarehouseService.deleteBatch(Arrays.asList(Integer.parseInt(ids)));
    }

    @RequestMapping("/save")
    public PageResult save(@RequestBody BaWarehouse baWarehouse) {
        return baWarehouseService.save(baWarehouse);
    }

  
}
