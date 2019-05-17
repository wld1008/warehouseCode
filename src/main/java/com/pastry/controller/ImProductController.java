package com.pastry.controller;

import com.pastry.pojo.ImProductDO;
import com.pastry.service.ImProductService;
import com.pastry.utils.result.PageResult;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/product")
public class ImProductController {
    @Resource
    private ImProductService imProductService;

    @RequestMapping("/list")
    public String queryList(HttpServletRequest request, HttpServletResponse response) {

        return "/product/list";
    }

    @ResponseBody
    @RequestMapping("/listData")
    public PageResult<List<ImProductDO>> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return imProductService.getAll(page, limit);
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
        return imProductService.deleteBatch(Arrays.asList(Integer.parseInt(ids)));
    }
    
    @RequestMapping("/save")
    public PageResult save(@RequestBody ImProductDO imProductDO) {
        return imProductService.save(userDO);
    }
}
