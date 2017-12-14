package com.wyu.ui.utils;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public class Response {
    private String code;
    private String error;
    private Object content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Response(String code, String error, Object content) {
        this.code = code;
        this.error = error;
        this.content = content;
    }
}
