package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 启动类也可以扮演配置类的角色
 */
@SpringBootApplication
//@EnableDiscoveryClient  这个注解在以前的版本中需要加上，注解的意思是：说明为nacos客户端 ，在最近的几个新版本中，这个注解可以省略了。
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    /**
     * 这里通常应该写到配置类中，这里为了写着方便
     */
    @Bean
    @LoadBalanced//默认是轮询算法
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }
}

