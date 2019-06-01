package com.bw.movie.bean;

import java.util.List;

public class MyByPiao {

    /**
     * result : [{"amount":3,"beginTime":"20:00:00","cinemaName":"CGV影城（清河店）","createTime":1559223222000,"endTime":"21:48:00","id":14067,"movieName":"无双","orderId":"20190530213342558","price":0.15,"screeningHall":"7号厅","status":1,"userId":1323},{"amount":3,"beginTime":"20:00:00","cinemaName":"CGV影城（清河店）","createTime":1559223220000,"endTime":"21:48:00","id":14066,"movieName":"无双","orderId":"20190530213340318","price":0.15,"screeningHall":"7号厅","status":1,"userId":1323},{"amount":3,"beginTime":"20:00:00","cinemaName":"CGV影城（清河店）","createTime":1559223215000,"endTime":"21:48:00","id":14065,"movieName":"无双","orderId":"20190530213335247","price":0.15,"screeningHall":"7号厅","status":1,"userId":1323},{"amount":1,"beginTime":"22:00:00","cinemaName":"大地影院-北京海淀西三旗物美","createTime":1559220803000,"endTime":"23:55:00","id":14058,"movieName":"江湖儿女","orderId":"20190530205323108","price":0.28,"screeningHall":"2号厅","status":1,"userId":1323},{"amount":2,"beginTime":"17:00:00","cinemaName":"东融国际影城西直河店","createTime":1559206890000,"endTime":"04:56:00","id":13995,"movieName":"无双","orderId":"20190530170130778","price":0.15,"screeningHall":"4号厅","status":1,"userId":1323},{"amount":1,"beginTime":"15:30:00","cinemaName":"CGV星星影城","createTime":1559188368000,"endTime":"17:32:00","id":13949,"movieName":"摩天营救","orderId":"20190530115248552","price":0.12,"screeningHall":"6号厅","status":1,"userId":1323},{"amount":2,"beginTime":"17:00:00","cinemaName":"东融国际影城西直河店","createTime":1559181846000,"endTime":"04:56:00","id":13890,"movieName":"江湖儿女","orderId":"20190530100406025","price":0.28,"screeningHall":"4号厅","status":1,"userId":1323},{"amount":1,"beginTime":"22:00:00","cinemaName":"北京沃美影城（回龙观店）","createTime":1559179629000,"endTime":"23:55:00","id":13879,"movieName":"江湖儿女","orderId":"20190530092709829","price":0.28,"screeningHall":"2号厅","status":1,"userId":1323},{"amount":1,"beginTime":"17:05:00","cinemaName":"大观楼电影院","createTime":1559115625000,"endTime":"19:03:00","id":13670,"movieName":"西虹市首富","orderId":"20190529154025791","price":0.13,"screeningHall":"3厅","status":1,"userId":1323},{"amount":1,"beginTime":"16:20:00","cinemaName":"CGV星星影城","createTime":1558965599000,"endTime":"18:18:00","id":13312,"movieName":"西虹市首富","orderId":"20190527215958995","price":0.13,"screeningHall":"9号厅 ","status":1,"userId":1323}]
     * message : 请求成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 3
         * beginTime : 20:00:00
         * cinemaName : CGV影城（清河店）
         * createTime : 1559223222000
         * endTime : 21:48:00
         * id : 14067
         * movieName : 无双
         * orderId : 20190530213342558
         * price : 0.15
         * screeningHall : 7号厅
         * status : 1
         * userId : 1323
         */

        private int amount;
        private String beginTime;
        private String cinemaName;
        private long createTime;
        private String endTime;
        private int id;
        private String movieName;
        private String orderId;
        private double price;
        private String screeningHall;
        private int status;
        private int userId;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
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

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
