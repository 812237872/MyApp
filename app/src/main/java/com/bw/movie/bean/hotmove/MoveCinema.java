package com.bw.movie.bean.hotmove;

public class MoveCinema {
    public String beginTime;
    public String duration;
    public String endTime;
    public int  id;
    public String screeningHall;
    public int seatsTotal;
    public int seatsUseCount;
    public int status;
    public float price;

    public MoveCinema(String beginTime, String duration, String endTime, int id, String screeningHall, int seatsTotal, int seatsUseCount, int status, float price) {
        this.beginTime = beginTime;
        this.duration = duration;
        this.endTime = endTime;
        this.id = id;
        this.screeningHall = screeningHall;
        this.seatsTotal = seatsTotal;
        this.seatsUseCount = seatsUseCount;
        this.status = status;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreeningHall() {
        return screeningHall;
    }

    public void setScreeningHall(String screeningHall) {
        this.screeningHall = screeningHall;
    }

    public int getSeatsTotal() {
        return seatsTotal;
    }

    public void setSeatsTotal(int seatsTotal) {
        this.seatsTotal = seatsTotal;
    }

    public int getSeatsUseCount() {
        return seatsUseCount;
    }

    public void setSeatsUseCount(int seatsUseCount) {
        this.seatsUseCount = seatsUseCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MoveCinema{" +
                "beginTime='" + beginTime + '\'' +
                ", duration='" + duration + '\'' +
                ", endTime='" + endTime + '\'' +
                ", id=" + id +
                ", screeningHall='" + screeningHall + '\'' +
                ", seatsTotal=" + seatsTotal +
                ", seatsUseCount=" + seatsUseCount +
                ", status=" + status +
                '}';
    }
}
