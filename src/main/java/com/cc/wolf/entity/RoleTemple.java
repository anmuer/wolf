package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("role_temple")
public class RoleTemple implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int people;
    @TableField(condition = SqlCondition.LIKE)
    private String schema;
    private Timestamp createTime;
    private String remarks;

}
