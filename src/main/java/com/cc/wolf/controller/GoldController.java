package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.Gold;
import com.cc.wolf.service.GoldService;
import com.cc.wolf.service.GoldService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/gold")
@Api
public class GoldController {

    @Autowired
    private GoldService goldService;

    @GetMapping
    public ApiResponse getGolds(Gold gold, Integer pageNo, Integer pageSize){
        if(null==pageNo || pageNo<1){
            pageNo = 1;
        }
        if(null==pageSize || pageSize<1){
            pageSize = 10;
        }
        IPage<Gold> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Gold> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(gold);
        return new ApiResponse(goldService.page(page,queryWrapper));
    }

    @PostMapping
    public ApiResponse insert(@RequestBody Gold gold){
        goldService.save(gold);
        return new ApiResponse();
    }

    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody Gold gold){
        gold.setId(id);
        goldService.updateById(gold);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }


    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        goldService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }


    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Integer id){
        goldService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
