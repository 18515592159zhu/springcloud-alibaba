package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigController3 {
    @Value("${config.env}")
    private String env;

    //3 同一微服务的不同环境下共享配置
    @GetMapping("/nacos-config-test3")
    public String nacosConfingTest3() {
        return env;
    }
}