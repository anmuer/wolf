package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.UserGame;
import com.cc.wolf.service.UserGameService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/userGame")
@Api
public class UserGameController {

    @Autowired
    private UserGameService userGameService;

    @GetMapping
    public ApiResponse getUserGames(UserGame userGame, Integer pageNo, Integer pageSize){
        if(null==pageNo || pageNo<1){
            pageNo = 1;
        }
        if(null==pageSize || pageSize<1){
            pageSize = 10;
        }
        IPage<UserGame> page = new Page<>(pageNo,pageSize);
        QueryWrapper<UserGame> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(userGame);
        return new ApiResponse(userGameService.page(page,queryWrapper));
    }


    @PostMapping
    public ApiResponse insert(@RequestBody UserGame userGame){
        userGameService.save(userGame);
        return new ApiResponse();
    }


    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody UserGame userGame){
        userGame.setId(id);
        userGameService.updateById(userGame);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }


    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        userGameService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }


    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Integer id){
        userGameService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
