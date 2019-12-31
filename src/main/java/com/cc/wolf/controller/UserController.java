package com.cc.wolf.controller;

import com.cc.wolf.entity.User;
import com.cc.wolf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.list();
    }

    @PostMapping
    public String insert(@RequestBody User user){
        return String.valueOf(userService.save(user));
    }

    @DeleteMapping
    public String delete(@RequestParam List<String> ids){
        return String.valueOf(userService.removeByIds(ids));
    }


}
