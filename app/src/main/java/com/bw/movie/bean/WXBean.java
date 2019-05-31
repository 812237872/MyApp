package com.bw.movie.bean;

public class WXBean {
    public WX result;

    public String message;

    public WXBean(WX result, String message) {
        this.result = result;
        this.message = message;
    }

    public WX getResult() {
        return result;
    }

    public void setResult(WX result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WXBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
