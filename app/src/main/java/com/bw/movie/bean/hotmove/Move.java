package com.bw.movie.bean.hotmove;

public class Move {
    public String director;
    public String duration;
    public String imageUrl;
    public String name;
    public String placeOrigin;
    public String starring;
    public String summary;
    public int id;

    public Move(String director, String duration, String imageUrl, String name, String placeOrigin, String starring, String summary, int id) {
        this.director = director;
        this.duration = duration;
        this.imageUrl = imageUrl;
        this.name = name;
        this.placeOrigin = placeOrigin;
        this.starring = starring;
        this.summary = summary;
        this.id = id;
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

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Move{" +
                "director='" + director + '\'' +
                ", duration='" + duration + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", starring='" + starring + '\'' +
                ", summary='" + summary + '\'' +
                ", id=" + id +
                '}';
    }
}
