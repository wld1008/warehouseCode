package com.pastry.utils;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * Created by wulidan on 18/7/25.
 */
public class DubboConsumerApi {
    private RegistryConfig registry;
    private ApplicationConfig application;
    private ConsumerConfig consumer;

    public DubboConsumerApi(){
        registry = new RegistryConfig();
        registry.setAddress("127.0.0.1:2181");
        registry.setProtocol("zookeeper");
        registry.setTimeout(3000);

        application = new ApplicationConfig();
        application.setName("wld");
        application.setOrganization("pastry");
        application.setOwner("wld");

        consumer= new ConsumerConfig();
        consumer.setGeneric(true);
        consumer.setGroup("impl");



    }

    public void handle(){
        ReferenceConfig<GenericService> refer = new ReferenceConfig<GenericService>();
        refer.setConsumer(consumer);
        refer.setApplication(application);
        refer.setRegistry(registry);
        refer.setInterface("");
    }


}
