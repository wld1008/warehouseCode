package com.pastry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wulidan on 18/7/25.
 */
@Controller
public class VisitController {

    @RequestMapping("/echo")
    public String echo(HttpServletRequest request, HttpServletResponse response){

        return "time";

    }

}
