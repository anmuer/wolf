package com.cc.wolf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wolf.ApiResponse;
import com.cc.wolf.entity.Role;
import com.cc.wolf.service.RoleService;
import com.cc.wolf.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wolf/role")
@Api
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ApiResponse getRoles(Role role, Integer pageNo, Integer pageSize){
        if(null==pageNo || pageNo<1){
            pageNo = 1;
        }
        if(null==pageSize || pageSize<1){
            pageSize = 10;
        }
        IPage<Role> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(role);
        return new ApiResponse(roleService.page(page,queryWrapper));
    }


    @PostMapping
    public ApiResponse insert(@RequestBody Role role){
        roleService.save(role);
        return new ApiResponse();
    }


    @PutMapping("{id}")
    public ApiResponse update(@PathVariable("id") Integer id, @RequestBody Role role){
        role.setId(id);
        roleService.updateById(role);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"更新成功");
    }


    @DeleteMapping
    public ApiResponse deleteBatch(@RequestParam List<Integer> ids){
        roleService.removeByIds(ids);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"批量删除成功");
    }


    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Integer id){
        roleService.removeById(id);
        return new ApiResponse(StatusCode.NO_CONTENT.getStatusCode(),"删除成功");
    }


}
