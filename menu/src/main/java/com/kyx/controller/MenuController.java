package com.kyx.controller;
import com.kyx.entity.MenuVO;
import com.kyx.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    private String index() {
        return "当前端口为" + this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return new MenuVO(0, "", menuRepository.count(), menuRepository.findAll(index, limit));
    }
    @DeleteMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable("id") long id){
         menuRepository.deleteById(id);
    }
}

