package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("role_template")
@ApiModel(value = "RoleTemplate")
public class RoleTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer people;
    @TableField(condition = SqlCondition.LIKE)
    private String schema;
    private Timestamp createTime;
    private String remarks;

}
