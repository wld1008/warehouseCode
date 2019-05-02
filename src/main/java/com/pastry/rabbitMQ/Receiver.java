package com.pastry.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wulidan on 18/6/24.
 */

//@Component
public class Receiver {

    @RabbitListener(queues = "hello-wld-queue")
    public void process(String msg){
        System.out.println("receiver" + msg);
    }
}
