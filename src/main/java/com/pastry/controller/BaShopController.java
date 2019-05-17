
package com.pastry.controller;

import com.pastry.pojo.BaShopDO;
import com.pastry.service.BaShopService;
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
@RequestMapping("/baShop")
public class BaShopController {
    @Resource
    private BaShopService baShopService;

    @RequestMapping("/list")
    public String queryList(HttpServletRequest request, HttpServletResponse response) {

        return "/shop/list";
    }

    @ResponseBody
    @RequestMapping("/listData")
    public PageResult<List<BaShopDO>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return baShopService.getAll(page, limit);
    }

//    @RequestMapping("/edit")
//    public String edit(){
//        return "/user/userDetail";
//    }
//
//    @RequestMapping("/save")
//    public String save(UserDO userDO){
//
//        return "";
//    }

    @ResponseBody
    @RequestMapping("/delete")
    public PageResult delete(@RequestParam("ids") String ids) {
        System.out.println(ids);
        return baShopService.deleteBatch(Arrays.asList(Integer.parseInt(ids)));
    }
    
    @RequestMapping("/save")
    public PageResult save(@RequestBody BaShopDO baShopDO) {
        return baShopService.save(baShopDO);
    }
    
}
