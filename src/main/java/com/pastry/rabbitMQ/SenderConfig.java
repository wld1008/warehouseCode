package com.pastry.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wulidan on 18/6/24.
 * 创建一个队列
 */

//@Configuration
public class SenderConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello-wld-queue");
    }
}
