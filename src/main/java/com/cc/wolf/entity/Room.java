package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
@TableName("room")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    @TableField(condition = SqlCondition.LIKE)
    private String roomName;
    private Timestamp createTime;
    private String remarks;

}
