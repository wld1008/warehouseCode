package com.pastry.controller;

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
      return "/warehouse/list";
  }
  
   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<BaShopDO>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
      return baWarehouseService.getAll(page, limit);
   }
  
}
