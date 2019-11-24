package com.kyx.controller;

import com.kyx.entity.Menu;
import com.kyx.entity.MenuVO;
import com.kyx.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/menu")
public class ClientMenuController {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{location}")
    //location随意去取的
    public String redirect(@PathVariable("location") String location) {
        return location;
    }
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")long id ){
        menuFeign.deleteById(id);
        return "redirect:/client/redirect/index";
    }
}
