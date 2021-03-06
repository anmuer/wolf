package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
@TableName("game")
@ApiModel(value = "Game")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer roomId;
    private Integer roleTemplateId;
    @TableField(condition = SqlCondition.LIKE)
    private String gameName;
    private String victoryRole;
    private String victoryUserIds;
    private String remarks;
    private Timestamp createTime;
    private Timestamp startTime;
    private Timestamp endTime;
    private String spend;
}
