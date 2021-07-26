package com.example.malllearning.controller;

import com.example.malllearning.service.CancelOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Api(tags = "OrderController",description = "订单管理")
public class OrderController {
    @Autowired
    private CancelOrderService cancelOrderService;

    @ApiOperation("取消订单")
    @GetMapping("/cancel")
    public String cancel(){
        cancelOrderService.cancelOrder();
        return "test";
    }
}
