package com.bw.movie.bean.hotmove;

import java.util.List;

public class CinemaBean {
    public List<Cinema> result;
    public String message;

    public CinemaBean(List<Cinema> result, String message) {
        this.result = result;
        this.message = message;
    }

    public List<Cinema> getResult() {
        return result;
    }

    public void setResult(List<Cinema> result) {
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
        return "CinemaBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
