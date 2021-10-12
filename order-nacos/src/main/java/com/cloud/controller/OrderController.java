package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 没有cloud组件时，可以用springboot集成的restTemplate或者原生httpclient进行服务之间的调用
     * 下面的这个方法就是一个调用的例子
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功");
        //这里的地址说明：这种传统的方式，大量的服务之间的调用和地址的变更导致复杂性增加，在微服务框架中利用注册中心的方式去管理各个微服务应用。
        //一个微服务地址的改变，导致相关的调用方进行改变，实在是灾难，这也是引入微服务组件的一个重要原因，这个组件就是注册中心。
        //同时也方便集群部署，负载调用。
        //引入注册中心以后只用用微服务名称：stock-service进行调用
        String msg = restTemplate.getForObject("http://stock-service/stock/reduce", String.class);
        return "hello world"+msg;
    }


}
