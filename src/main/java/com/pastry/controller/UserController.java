package com.pastry.controller;

import com.alibaba.dubbo.config.support.Parameter;
import com.pastry.pojo.UserDO;
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
 * Created by wulidan on 19/5/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public PageResult<List<UserDO>> userList(@RequestParam("username") String userName,
                                             @RequestParam("password") String password) {
        PageResult result = new PageResult<>();
        result.setMsg("登录成功");
        return result;
    }


    @RequestMapping("/list")
    public String queryUser(HttpServletRequest request, HttpServletResponse response) {

        return "/user/userInfo";
    }

    @ResponseBody
    @RequestMapping("/userList")
    public PageResult<List<UserDO>> userList(@RequestParam("page") int page,@RequestParam("limit") int limit) {
       return userService.getAllUser(page, limit);
    }

    @RequestMapping("/edit")
    public String edit(){
        return "/user/userDetail";
    }

//    @RequestMapping("/save")
//    public String save(UserDO userDO){
//
//        return ;
//    }

    @ResponseBody
    @RequestMapping("/delete")
    public PageResult delete(@RequestParam("ids") String ids) {
        System.out.println(ids);
        return userService.deleteUserById(Arrays.asList(Integer.parseInt(ids)));
    }

    @RequestMapping("/save")
    public PageResult save(@RequestBody UserDO userDO) {
        return userService.save(userDO);
    }

}
