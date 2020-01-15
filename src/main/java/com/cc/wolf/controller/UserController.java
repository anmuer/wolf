package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.User;
import com.cc.wolf.service.UserService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/user")
@Api
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户")
    @GetMapping
    public ApiResponse getUsers(Page<User> user, QueryWrapper<User> userQueryWrapper){
        return new ApiResponse(userService.page(user,userQueryWrapper));
    }

    @ApiOperation(value = "保存用户")
    @PostMapping
    public ApiResponse insert(@RequestBody User user){
        userService.save(user);
        return new ApiResponse();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody User user){
        user.setId(id);
        userService.updateById(user);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }

    @ApiOperation(value = "批量删除用户")
    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        userService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Integer id){
        userService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
