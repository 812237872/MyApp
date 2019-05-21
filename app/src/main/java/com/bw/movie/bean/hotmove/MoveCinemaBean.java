package com.bw.movie.bean.hotmove;

import java.util.List;

public class MoveCinemaBean {
    public List<MoveCinema> result;
    public String message;

    public MoveCinemaBean(List<MoveCinema> result, String message) {
        this.result = result;
        this.message = message;
    }

    public List<MoveCinema> getResult() {
        return result;
    }

    public void setResult(List<MoveCinema> result) {
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
        return "MoveCinemaBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
