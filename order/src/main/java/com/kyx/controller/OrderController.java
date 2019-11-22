package com.kyx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    private String index() {
        return "当前端口为"+this.port;
    }
}
