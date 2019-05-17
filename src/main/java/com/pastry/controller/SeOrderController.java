package com.pastry.controller;

import com.pastry.pojo.SeOrder;
import com.pastry.pojo.UserDO;
import com.pastry.service.SeOrderService;
import com.pastry.service.UserService;
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
 * Created by wulidan on 19/5/6.
 */
@Controller
@RequestMapping("/order")
public class SeOrderController {

    @Resource
    private SeOrderService seOrderService;

    @RequestMapping("/list")
    public String queryUser(HttpServletRequest request, HttpServletResponse response) {

        return "/order/orderlist";
    }

    @ResponseBody
    @RequestMapping("/listData")
    public PageResult<List<SeOrder>> userList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return seOrderService.getAllOrder(page, limit);
    }

    @RequestMapping("/edit")
    public String edit(){
        return "/order/detail";
    }


    @ResponseBody
    @RequestMapping("/delete")
    public PageResult delete(@RequestParam("ids") String ids) {
        System.out.println(ids);
        return seOrderService.deleteOrderById(Arrays.asList(Integer.parseInt(ids)));
    }
    
    @RequestMapping("/save")
    public PageResult save(@RequestBody SeOrder seOrder) {
        return seOrderService.save(seOrder);
    }
}
