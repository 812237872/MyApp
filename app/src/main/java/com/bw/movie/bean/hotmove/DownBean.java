package com.bw.movie.bean.hotmove;

public class DownBean {
    public String orderId;
    public String message;

    public DownBean(String orderId, String message) {
        this.orderId = orderId;
        this.message = message;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DownBean{" +
                "orderId='" + orderId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
