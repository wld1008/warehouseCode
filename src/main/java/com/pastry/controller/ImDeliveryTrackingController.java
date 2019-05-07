package com.pastry.controller;

import com.pastry.pojo.ImDeliveryTracking;
import com.pastry.service.ImDeliveryTrackingService;
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
@RequestMapping("/deliveryTrack")
public class ImDeliveryTrackingController {
  
  @Resource
  private ImDeliveryTrackingService deliveryTrackingService;
  
  @RequestMapping("/list")
  public String queryList(HttpServletRequest request, HttpServletResponse response) {
      return "/delivery/list";
  }
  
   @ResponseBody
   @RequestMapping("/listData")
   public PageResult<List<ImDeliveryTracking>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
      return deliveryTrackingService.getAll(page, limit);
   }
}
