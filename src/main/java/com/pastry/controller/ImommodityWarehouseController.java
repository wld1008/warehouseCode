package com.pastry.controller;

/**
 * Created by wulidan on 19/5/7.
 */
@Controller
@RequestMapping("/imommodityWarehouse")
public class ImommodityWarehouseController {
  @Resource
  private ImommodityWarehouseService imommodityWarehouseService;
  
  @RequestMapping("/list")
  public String queryList(HttpServletRequest request, HttpServletResponse response) {
      return "/imommodityWarehouse/list";
  }
  
   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<ImommodityWarehouse>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
      return imommodityWarehouseService.getAll(page, limit);
   }
}
