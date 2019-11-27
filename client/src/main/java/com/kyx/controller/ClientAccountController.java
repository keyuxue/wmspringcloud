package com.kyx.controller;

import com.kyx.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class ClientAccountController {
    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type) {

        Object object = accountFeign.login(username, password, type);
        System.out.println(object);
        return "index";

    }
}
