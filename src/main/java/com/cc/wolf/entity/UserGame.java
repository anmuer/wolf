package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
@TableName("user_game")
@ApiModel(value = "UserGame")
public class UserGame implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer gameId;
    private Integer userId;
    private String roleName;
    private int seatNumber;
    @TableField(condition = SqlCondition.LIKE)
    private String tips;
    private String voice;
    @TableField(condition = SqlCondition.LIKE)
    private String deadSituation;
    private Timestamp deadTime;
    private Timestamp createTime;
    private String remarks;

}
