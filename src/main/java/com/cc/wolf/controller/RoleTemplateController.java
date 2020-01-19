package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.RoleTemplate;
import com.cc.wolf.service.RoleTemplateService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/roleTemplate")
@Api
public class RoleTemplateController {

    @Autowired
    private RoleTemplateService roleTemplateService;

    @GetMapping
    public ApiResponse getRoleTemplates(RoleTemplate roleTemplate, Integer pageNo, Integer pageSize){
        if(null==pageNo || pageNo<1){
            pageNo = 1;
        }
        if(null==pageSize || pageSize<1){
            pageSize = 10;
        }
        IPage<RoleTemplate> page = new Page<>(pageNo,pageSize);
        QueryWrapper<RoleTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(roleTemplate);
        return new ApiResponse(roleTemplateService.page(page,queryWrapper));
    }


    @PostMapping
    public ApiResponse insert(@RequestBody RoleTemplate roleTemplate){
        roleTemplateService.save(roleTemplate);
        return new ApiResponse();
    }


    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody RoleTemplate roleTemplate){
        roleTemplate.setId(id);
        roleTemplateService.updateById(roleTemplate);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }


    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        roleTemplateService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }


    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Integer id){
        roleTemplateService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
