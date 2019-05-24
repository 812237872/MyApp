package com.bw.movie.bean;

public class WX {
    public String sessionId;
    public int userId;
    public User userInfo;

    public WX(String sessionId, int userId, User userInfo) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.userInfo = userInfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "WX{" +
                "sessionId='" + sessionId + '\'' +
                ", userId=" + userId +
                ", userInfo=" + userInfo +
                '}';
    }
}
