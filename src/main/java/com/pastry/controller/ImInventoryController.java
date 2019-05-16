package com.pastry.controller;

import com.pastry.mapping.ImProductDOMapper;
import com.pastry.pojo.ImInventory;
import com.pastry.service.ImInventoryService;
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
@RequestMapping("/inventory")
public class ImInventoryController {
  @Resource
  private ImInventoryService imInventoryService;

  @RequestMapping("/list")
  public String queryList(HttpServletRequest request, HttpServletResponse response) {
      return "/inventory/list";
  }
  
   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<ImInventory>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {

      return imInventoryService.getAll(page, limit);
   }
}
