package com.bw.movie.bean.hotmove;

public class VideoImg {
    public String imageUrl;
    public String videoUrl;

    public VideoImg(String imageUrl, String videoUrl) {
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "VideoImg{" +
                "imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
