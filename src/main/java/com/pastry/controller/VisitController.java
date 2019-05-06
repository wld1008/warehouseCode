package com.pastry.controller;

import com.pastry.mapping.UserMapper;
import com.pastry.pojo.UserDO;
import com.pastry.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by wulidan on 18/7/25.
 */
@Controller
public class VisitController {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @RequestMapping("/echo")
    public String echo(HttpServletRequest request, HttpServletResponse response){
        return "time";

    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }

}
