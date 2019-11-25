package com.kyx.controller;

import com.kyx.entity.User;
import com.kyx.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ClientUserController {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll/{page}/{limit}")
    @ResponseBody
    public List<User> findAll(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        int index = (page - 1) * limit;
        return userFeign.findAll(index, limit);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id) {
        return userFeign.findById(id);
    }


    @GetMapping("/count")
    public int count() {
        return userFeign.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userFeign.save(user);
    }


    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userFeign.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userFeign.deleteById(id);
    }
};
