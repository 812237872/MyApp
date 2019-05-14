package com.bw.movie.bean;

public class HotMove {
    public boolean followMovie;
    public int id;
    public int rank;
    public String imageUrl;
    public String name;
    public String summary;

    public HotMove(boolean followMovie, int id, int rank, String imageUrl, String name, String summary) {
        this.followMovie = followMovie;
        this.id = id;
        this.rank = rank;
        this.imageUrl = imageUrl;
        this.name = name;
        this.summary = summary;
    }

    public boolean isFollowMovie() {
        return followMovie;
    }

    public void setFollowMovie(boolean followMovie) {
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

    @Override
    public String toString() {
        return "HotMove{" +
                "followMovie=" + followMovie +
                ", id=" + id +
                ", rank=" + rank +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
