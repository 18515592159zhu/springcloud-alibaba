package com.itheima.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.itheima.service.impl.OrderServiceImpl3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController3 {

    @Autowired
    private OrderServiceImpl3 orderServiceImpl3;

    @RequestMapping("/order/message1")
    public String message1() {
        orderServiceImpl3.message();
        return "message1";
    }


    int i = 0;

    @RequestMapping("/order/message2")
    public String message2() {
        orderServiceImpl3.message();
        i++;
        //异常比例为0.333
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "message2";
    }

    @RequestMapping("/order/message3")
    @SentinelResource("message3")//注意这里必须使用这个注解标识,热点规则不生效
    public String message3(String name, Integer age) {
        return name + age;
    }

}