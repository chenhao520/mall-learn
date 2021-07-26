package com.example.malllearning.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    @RabbitHandler
    public void handler(Long orderId){
        log.info("receiver delay message orderId:{}",orderId);
        System.out.println("取消订单 ");

    }
}
