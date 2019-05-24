package com.bw.movie.bean.Dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HotMove {
    public int followMovie;
    public int id;
    public int rank;
    public String imageUrl;
    public String name;
    public String summary;
    public String releaseTimeShow;
    @Generated(hash = 555630414)
    public HotMove(int followMovie, int id, int rank, String imageUrl, String name,
            String summary, String releaseTimeShow) {
        this.followMovie = followMovie;
        this.id = id;
        this.rank = rank;
        this.imageUrl = imageUrl;
        this.name = name;
        this.summary = summary;
        this.releaseTimeShow = releaseTimeShow;
    }
    @Generated(hash = 204840421)
    public HotMove() {
    }
    public int getFollowMovie() {
        return this.followMovie;
    }
    public void setFollowMovie(int followMovie) {
        this.followMovie = followMovie;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRank() {
        return this.rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSummary() {
        return this.summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getReleaseTimeShow() {
        return this.releaseTimeShow;
    }
    public void setReleaseTimeShow(String releaseTimeShow) {
        this.releaseTimeShow = releaseTimeShow;
    }

}
