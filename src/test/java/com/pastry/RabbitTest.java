package com.pastry;

import com.pastry.rabbitMQ.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wulidan on 18/6/25.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationController.class)

public class RabbitTest {

    @Autowired
    private Sender sender;

    @Test
    public void send(){
        sender.send();
    }
}
