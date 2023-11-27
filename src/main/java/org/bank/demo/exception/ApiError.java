package org.bank.demo.exception;

import java.util.Date;

public class ApiError {
    private Integer code;
    private String message;
    private Date time;

    public ApiError() {
        this.time = new Date();
    }

    public ApiError(Integer code, String message, Date time) {
        super();
        this.code = code;
        this.message = message;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
