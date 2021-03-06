package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.Game;
import com.cc.wolf.service.GameService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/game")
@Api
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping
    public ApiResponse getGames(Game game, Integer pageNo, Integer pageSize){
        if(null==pageNo || pageNo<1){
            pageNo = 1;
        }
        if(null==pageSize || pageSize<1){
            pageSize = 10;
        }
        IPage<Game> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Game> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(game);
        return new ApiResponse(gameService.page(page,queryWrapper));
    }

    @PostMapping
    public ApiResponse insert(@RequestBody Game game){
        gameService.save(game);
        return new ApiResponse();
    }

    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody Game game){
        game.setId(id);
        gameService.updateById(game);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }

    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        gameService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }
    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable @RequestParam Integer id){
        gameService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
