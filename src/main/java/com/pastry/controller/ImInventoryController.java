package com.pastry.controller;

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
      return "/delivery/list";
  }
  
   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<ImInventory>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
      return imInventoryService.getAll(page, limit);
   }
}
