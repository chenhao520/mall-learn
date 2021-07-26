package com.example.malllearning.service.impl;

import com.example.malllearning.component.CancelOrderSender;
import com.example.malllearning.service.CancelOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CancelOrderServiceImpl implements CancelOrderService {
    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Override
    public void cancelOrder() {
        log.info("发送延迟消息");
        cancelOrderSender.sendMessage(1L,10 * 1000);
    }
}
