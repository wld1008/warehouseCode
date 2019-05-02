package com.pastry.controller;

import com.pastry.pojo.LoginUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wulidan on 18/6/25.
 */

@Controller
public class WelcomController {

    @Resource
    private RedisTemplate<String,LoginUser> redisTemplate;


    @RequestMapping("/hello")
    public String home(HttpServletRequest request, HttpServletResponse response){

        System.out.println("/>>>>>>>>>>>>>>>>");
        return "demo";
    }
}
