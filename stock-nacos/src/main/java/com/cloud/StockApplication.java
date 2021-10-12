package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 启动类也可以扮演配置类的角色
 */
@SpringBootApplication
//@EnableDiscoveryClient  这个注解在以前的版本中需要加上，注解的意思是：说明为nacos客户端 ，在最近的几个新版本中，这个注解可以省略了。
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class,args);
    }
}
