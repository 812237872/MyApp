package com.bw.movie.bean;

public class User {
    public long birthday;
    public int id;
    public long lastLoginTime;
    public String nickName;
    public String phone;
    public int sex;
    public String headPic;

    public User(long birthday, int id, long lastLoginTime, String nickName, String phone, int sex, String headPic) {
        this.birthday = birthday;
        this.id = id;
        this.lastLoginTime = lastLoginTime;
        this.nickName = nickName;
        this.phone = phone;
        this.sex = sex;
        this.headPic = headPic;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    @Override
    public String toString() {
        return "User{" +
                "birthday=" + birthday +
                ", id=" + id +
                ", lastLoginTime=" + lastLoginTime +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", headPic='" + headPic + '\'' +
                '}';
    }
}
