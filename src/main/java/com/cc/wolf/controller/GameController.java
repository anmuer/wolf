package com.cc.wolf.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.Game;
import com.cc.wolf.service.GameService;
import com.cc.wolf.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/game")
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping
    public ApiResponse getGames(Page<Game> game){
        return new ApiResponse(gameService.page(game));
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
