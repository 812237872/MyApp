package com.bw.movie.bean.hotmove;

public class MoveXiangBean {
    public MoveXiang result;
    public String message;

    public MoveXiangBean(MoveXiang result, String message) {
        this.result = result;
        this.message = message;
    }

    public MoveXiang getResult() {
        return result;
    }

    public void setResult(MoveXiang result) {
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
        return "MoveXiangBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
