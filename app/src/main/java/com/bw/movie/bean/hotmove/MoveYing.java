package com.bw.movie.bean.hotmove;

public class MoveYing {
    public int commentId;
    public String commentTime;
    public int greatNum;
    public int replyNum;
    public String commentHeadPic;
    public int hotComment;
    public int isGreat;
    public int commentUserId;
    public String commentContent;
    public String commentUserName;

    public MoveYing(int commentId, String commentTime, int greatNum, int replyNum, String commentHeadPic, int hotComment, int isGreat, int commentUserId, String commentContent, String commentUserName) {
        this.commentId = commentId;
        this.commentTime = commentTime;
        this.greatNum = greatNum;
        this.replyNum = replyNum;
        this.commentHeadPic = commentHeadPic;
        this.hotComment = hotComment;
        this.isGreat = isGreat;
        this.commentUserId = commentUserId;
        this.commentContent = commentContent;
        this.commentUserName = commentUserName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public int getGreatNum() {
        return greatNum;
    }

    public void setGreatNum(int greatNum) {
        this.greatNum = greatNum;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public String getCommentHeadPic() {
        return commentHeadPic;
    }

    public void setCommentHeadPic(String commentHeadPic) {
        this.commentHeadPic = commentHeadPic;
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

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    @Override
    public String toString() {
        return "MoveYing{" +
                "commentId=" + commentId +
                ", commentTime='" + commentTime + '\'' +
                ", greatNum=" + greatNum +
                ", replyNum=" + replyNum +
                ", commentHeadPic='" + commentHeadPic + '\'' +
                ", hotComment=" + hotComment +
                ", isGreat=" + isGreat +
                ", commentUserId=" + commentUserId +
                ", movieComment='" + commentContent + '\'' +
                ", commentUserName='" + commentUserName + '\'' +
                '}';
    }
}
