package com.itheima.service;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

@Slf4j
@RocketMQMessageListener(
        consumerGroup = "shop",//消费者分组
        topic = "order-topic",//要消费的主题
        consumeMode = ConsumeMode.CONCURRENTLY, //消费模式:无序和有序
        messageModel = MessageModel.CLUSTERING //消息模式:广播和集群,默认是集群
)
public class SmsService1 implements RocketMQListener<Order> {
    public void onMessage(Order order) {
        log.info("收到一个订单信息{},接下来发送短信", JSON.toJSONString(order));
    }
}
