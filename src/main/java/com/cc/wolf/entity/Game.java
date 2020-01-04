package com.cc.wolf.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Timestamp;

@TableName("game")
public class Game implements Serializable {
    private int id;
    private int roomId;
    private int gameTempleId;
    private String gameName;
    private String victoryRole;
    private String victoryUserIds;
    private String remarks;
    private Timestamp createTime;
    private Timestamp startTime;
    private Timestamp endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameTempleId() {
        return gameTempleId;
    }

    public void setGameTempleId(int gameTempleId) {
        this.gameTempleId = gameTempleId;
    }

    public String getVictoryRole() {
        return victoryRole;
    }

    public void setVictoryRole(String victoryRole) {
        this.victoryRole = victoryRole;
    }

    public String getVictoryUserIds() {
        return victoryUserIds;
    }

    public void setVictoryUserIds(String victoryUserIds) {
        this.victoryUserIds = victoryUserIds;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
