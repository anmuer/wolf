package com.cc.wolf;

import com.cc.wolf.utils.StatusCode;

import java.io.Serializable;

public class ApiResponse implements Serializable {
    private static final long serialVersuinUID = 89854574938928L;

    private Integer code;
    private String message;
    private Object data;

    public ApiResponse(){
        this.code = StatusCode.SUCCESS.getStatusCode();
        this.message = StatusCode.SUCCESS.getStatusMessage();
    }
    public ApiResponse(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public ApiResponse(Object data){
        this.code = StatusCode.SUCCESS.getStatusCode();
        this.message = StatusCode.SUCCESS.getStatusMessage();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
