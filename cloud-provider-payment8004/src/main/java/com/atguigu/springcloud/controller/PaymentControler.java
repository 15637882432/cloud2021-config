package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentControler {
    @Value("${server.port}")
    private String serverPort;
@RequestMapping(value = "/payment/zk")
    public String paymentzk(){
return "zookeeper"+serverPort+ UUID.randomUUID().toString();
    }

}
