package com.pastry.controller;

import com.pastry.pojo.ImCommodityWarehouse;
import com.pastry.service.ImCommodityWarehouseService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wulidan on 19/5/7.
 */
@Controller
@RequestMapping("/imCommodityWarehouse")
public class ImCommodityWarehouseController {
  @Resource
  private ImCommodityWarehouseService imCommodityWarehouseService;

  @RequestMapping("/list")
  public String queryList(HttpServletRequest request, HttpServletResponse response) {
      return "/imCommodityWarehouse/list";
  }

   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<ImCommodityWarehouse>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
      return imCommodityWarehouseService.getAll(page, limit);
   }
}