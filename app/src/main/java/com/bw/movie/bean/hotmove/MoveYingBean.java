package com.bw.movie.bean.hotmove;

import java.util.List;

public class MoveYingBean {
    public List<MoveYing> result;
    public String message;

    public MoveYingBean(List<MoveYing> result, String message) {
        this.result = result;
        this.message = message;
    }

    public List<MoveYing> getResult() {
        return result;
    }

    public void setResult(List<MoveYing> result) {
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
        return "MoveYingBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
