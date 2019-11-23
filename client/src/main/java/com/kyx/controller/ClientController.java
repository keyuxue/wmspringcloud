package com.kyx.controller;

import com.kyx.entity.Menu;
import com.kyx.entity.MenuVO;
import com.kyx.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        MenuVO menuVO=menuFeign.findAll(index, limit);
        return menuVO;
    }

    @GetMapping("/redirect/{location}")
    //location随意去取的
    public String redirect(@PathVariable("location") String location) {
        return location;
    }
}
