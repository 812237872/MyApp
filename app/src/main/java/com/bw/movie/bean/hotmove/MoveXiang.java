package com.bw.movie.bean.hotmove;

import android.widget.ListView;

import java.util.List;

public class MoveXiang {
    public String director;
    public String duration;
    public int  followMovie;
    public int id;
    public String imageUrl;
    public String movieTypes;
    public String name;
    public String placeOrigin;
    public List<String> posterList;
    public List<VideoImg> shortFilmList;
    public String starring;
    public String summary;

    public MoveXiang(String director, String duration, int followMovie, int id, String imageUrl, String movieTypes, String name, String placeOrigin, List<String> posterList, List<VideoImg> shortFilmList, String starring, String summary) {
        this.director = director;
        this.duration = duration;
        this.followMovie = followMovie;
        this.id = id;
        this.imageUrl = imageUrl;
        this.movieTypes = movieTypes;
        this.name = name;
        this.placeOrigin = placeOrigin;
        this.posterList = posterList;
        this.shortFilmList = shortFilmList;
        this.starring = starring;
        this.summary = summary;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMovieTypes() {
        return movieTypes;
    }

    public void setMovieTypes(String movieTypes) {
        this.movieTypes = movieTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public List<String> getPosterList() {
        return posterList;
    }

    public void setPosterList(List<String> posterList) {
        this.posterList = posterList;
    }

    public List<VideoImg> getShortFilmList() {
        return shortFilmList;
    }

    public void setShortFilmList(List<VideoImg> shortFilmList) {
        this.shortFilmList = shortFilmList;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "MoveXiang{" +
                "director='" + director + '\'' +
                ", duration='" + duration + '\'' +
                ", followMovie=" + followMovie +
                ", id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", movieTypes='" + movieTypes + '\'' +
                ", name='" + name + '\'' +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", posterList=" + posterList +
                ", shortFilmList=" + shortFilmList +
                ", starring='" + starring + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
