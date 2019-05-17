package com.bw.movie.bean;

import java.util.List;

public class EvaluateFragmentBean {


    /**
     * result : [{"commentContent":"123","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-04-18/20190418165656.png","commentId":621,"commentTime":1555751744000,"commentUserId":12556,"commentUserName":"大晴，起床喝药啦","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"晴晴晴晴晴晴晴晴","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-04-18/20190418165656.png","commentId":619,"commentTime":1555751464000,"commentUserId":12556,"commentUserName":"大晴，起床喝药啦","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"晴晴","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-04-18/20190418165656.png","commentId":617,"commentTime":1555751278000,"commentUserId":12556,"commentUserName":"大晴，起床喝药啦","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"晴晴","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-04-18/20190418165656.png","commentId":618,"commentTime":1555751278000,"commentUserId":12556,"commentUserName":"大晴，起床喝药啦","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"晴晴","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-04-18/20190418165656.png","commentId":616,"commentTime":1555751277000,"commentUserId":12556,"commentUserName":"大晴，起床喝药啦","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"晴晴","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-04-18/20190418165656.png","commentId":615,"commentTime":1555751276000,"commentUserId":12556,"commentUserName":"大晴，起床喝药啦","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"棒棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-02-23/20190223091036.jpg","commentId":325,"commentTime":1554620685000,"commentUserId":201,"commentUserName":"hhh","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"棒棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-02-23/20190223091036.jpg","commentId":324,"commentTime":1554620672000,"commentUserId":201,"commentUserName":"hhh","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"棒棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-02-23/20190223091036.jpg","commentId":323,"commentTime":1554620659000,"commentUserId":201,"commentUserName":"hhh","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"棒棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-02-23/20190223091036.jpg","commentId":322,"commentTime":1554620646000,"commentUserId":201,"commentUserName":"hhh","greatNum":2,"hotComment":0,"isGreat":0}]
     * message : 查询成功
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
         * commentContent : 123
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-04-18/20190418165656.png
         * commentId : 621
         * commentTime : 1555751744000
         * commentUserId : 12556
         * commentUserName : 大晴，起床喝药啦
         * greatNum : 2
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }
    }
}
