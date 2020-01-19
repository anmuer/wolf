package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.Video;
import com.cc.wolf.service.VideoService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/video")
@Api
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ApiResponse getVideos(Video video, Integer pageNo, Integer pageSize){
        if(null==pageNo || pageNo<1){
            pageNo = 1;
        }
        if(null==pageSize || pageSize<1){
            pageSize = 10;
        }
        IPage<Video> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(video);
        return new ApiResponse(videoService.page(page,queryWrapper));
    }


    @PostMapping
    public ApiResponse insert(@RequestBody Video video){
        videoService.save(video);
        return new ApiResponse();
    }


    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody Video video){
        video.setId(id);
        videoService.updateById(video);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }


    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        videoService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }


    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Integer id){
        videoService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
