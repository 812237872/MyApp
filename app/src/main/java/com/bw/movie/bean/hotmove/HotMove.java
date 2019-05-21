package com.bw.movie.bean.hotmove;

public class HotMove {
    public int followMovie;
    public int id;
    public int rank;
    public String imageUrl;
    public String name;
    public String summary;
    public String releaseTimeShow;

    public HotMove(int followMovie, int id, int rank, String imageUrl, String name, String summary, String releaseTimeShow) {
        this.followMovie = followMovie;
        this.id = id;
        this.rank = rank;
        this.imageUrl = imageUrl;
        this.name = name;
        this.summary = summary;
        this.releaseTimeShow = releaseTimeShow;
    }

    public int getFollowMovie() {
        return followMovie;
    }

    public void setFollowMovie(int followMovie) {
        this.followMovie = followMovie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReleaseTimeShow() {
        return releaseTimeShow;
    }

    public void setReleaseTimeShow(String releaseTimeShow) {
        this.releaseTimeShow = releaseTimeShow;
    }

    @Override
    public String toString() {
        return "HotMove{" +
                "followMovie=" + followMovie +
                ", id=" + id +
                ", rank=" + rank +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", releaseTimeShow='" + releaseTimeShow + '\'' +
                '}';
    }
}
