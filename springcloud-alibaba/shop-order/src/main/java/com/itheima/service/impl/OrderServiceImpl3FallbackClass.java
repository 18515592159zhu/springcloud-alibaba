package com.itheima.service.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceImpl3FallbackClass {
    //注意这里必须使用static修饰方法
    public static String fallback(Throwable throwable) {
        log.error("{}", throwable);
        return "接口发生异常了...";
    }
}