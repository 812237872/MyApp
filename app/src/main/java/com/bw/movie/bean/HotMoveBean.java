package com.bw.movie.bean;

import java.util.List;

public class HotMoveBean {
    public List<HotMove> result;
    public String message;

    public HotMoveBean(List<HotMove> result, String message) {
        this.result = result;
        this.message = message;
    }

    public List<HotMove> getResult() {
        return result;
    }

    public void setResult(List<HotMove> result) {
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
        return "HotMoveBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
