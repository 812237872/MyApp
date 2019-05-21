package com.bw.movie.bean.hotmove;

public class MoveBean {
    public Move result;
    public String message;

    public MoveBean(Move result, String message) {
        this.result = result;
        this.message = message;
    }

    public Move getResult() {
        return result;
    }

    public void setResult(Move result) {
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
        return "MoveBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
