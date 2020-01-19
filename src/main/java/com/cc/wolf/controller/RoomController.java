package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.Room;
import com.cc.wolf.service.RoomService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/room")
@Api
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ApiResponse getRooms(Room room, Integer pageNo, Integer pageSize){
        if(null==pageNo || pageNo<1){
            pageNo = 1;
        }
        if(null==pageSize || pageSize<1){
            pageSize = 10;
        }
        IPage<Room> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(room);
        return new ApiResponse(roomService.page(page,queryWrapper));
    }


    @PostMapping
    public ApiResponse insert(@RequestBody Room room){
        roomService.save(room);
        return new ApiResponse();
    }


    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody Room room){
        room.setId(id);
        roomService.updateById(room);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }


    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        roomService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }


    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Integer id){
        roomService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
