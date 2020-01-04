package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Timestamp;

@TableName("user_game")
public class UserGame implements Serializable {
    private int id;
    private int gameId;
    private int userId;
    private String roleName;
    private int seatNumber;
    private String tips;
    private String voice;
    private String deadSituation;
    private Timestamp deadTime;
    private Timestamp createTime;
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getDeadSituation() {
        return deadSituation;
    }

    public void setDeadSituation(String deadSituation) {
        this.deadSituation = deadSituation;
    }

    public Timestamp getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(Timestamp deadTime) {
        this.deadTime = deadTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
