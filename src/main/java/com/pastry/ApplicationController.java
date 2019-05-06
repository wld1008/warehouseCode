package com.pastry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wulidan on 18/6/25.
 */

@SpringBootApplication
@ComponentScan("com.pastry")
@MapperScan("com.pastry.mapping")
public class ApplicationController {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationController.class, args);
    }
}
