package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
@TableName("user")  // 实体类的类名和数据库表名不一致时候可用
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId("id")   // 实体类的主键名称和表中主键名称不一致时候可用
    private int id;
    @TableField(condition = SqlCondition.LIKE)
    private String userName;
    @TableField("pass_word")  // 实体类中的成员名称和表中字段名称不一致时候可用
    private String passWord;
    @TableField(condition = SqlCondition.LIKE)
    private String nickName;
    private String phone;
    private String openId;
    private Timestamp createTime;
    private String remarks;

}
