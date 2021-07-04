package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentControler {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = {"/payment/create"})
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("jieguo " + result);
        if (result > 0) {
            return new CommonResult(200, "chenggong" + serverPort, result);
        } else {
            return new CommonResult(444, "shibai" + serverPort);
        }
    }

    @GetMapping(value = {"/payment/get/{id}"})
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("jieguo " + result);
        if (result != null) {
            return new CommonResult(200, "chenggong"+ serverPort, result);
        } else {
            return new CommonResult(444, "shibai"+ serverPort);
        }
    }
}
