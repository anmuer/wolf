package com.cc.wolf.utils;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusCode {
    SUCCESS(200, "成功"),
    CREATE(201,"资源创建成功"),
    ACCEPTED(202, "服务器已接受请求，但尚未处理"),
    NO_CONTENT(204, "服务器成功处理了请求，但不需要返回任何实体内容"),
    MOVED_PERMANENTLY(301, "被请求的资源已永远的移到新位置"),
    BAD_REQUEST(400, "语义有误或者参数错误"),
    UNAUTHORIZED(401, "当前请求需要用户验证"),
    FORBIDDEN(403, "权限失败"),
    NOT_FOUND(404, "请求资源不存在"),
    UNSUPPORTED_MEDIA_TYPE(415, "服务器不支持的媒体内容"),
    ERROR(500, "系统错误");

    private String message;
    private int code;

    private StatusCode(int statusCode, String statusMessage) {
        this.message = statusMessage;
        this.code = statusCode;
    }

    @JsonValue
    public String getStatusMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.code;
    }

}
