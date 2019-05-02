package com.pastry.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wulidan on 18/6/24.
 */

//@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg = "hello" + new Date();
        this.amqpTemplate.convertAndSend("hello-wld-queue"+msg);
    }
}
