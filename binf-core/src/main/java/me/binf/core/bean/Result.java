package me.binf.core.bean;

import java.io.Serializable;

/**
 * Created by wangbin on 14-10-17.
 */
public class Result implements Serializable {

    private boolean success;

    private String msg;

    private int error;

    private Object data;


    public Result(boolean success) {
        this.success = success;
    }


    public Result msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result error(int error) {
        this.error = error;
        return this;
    }

    public Result data(Object data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
