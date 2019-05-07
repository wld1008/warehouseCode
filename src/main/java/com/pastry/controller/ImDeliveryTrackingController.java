package com.pastry.controller;

/**
 * Created by wulidan on 19/5/7.
 */
@Controller
@RequestMapping("/deliveryTrack")
public class ImDeliveryTrackingController {
  
  @Resource
  private ImDeliveryTracking deliveryTracking;
  
  @RequestMapping("/list")
  public String queryList(HttpServletRequest request, HttpServletResponse response) {
      return "/delivery/list";
  }
  
   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<ImDeliveryTracking>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
      return deliveryTracking.getAll(page, limit);
   }
}
