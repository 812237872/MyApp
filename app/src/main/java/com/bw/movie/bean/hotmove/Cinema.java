package com.bw.movie.bean.hotmove;

public class Cinema {
    public int id;
    public String address;
    public String name;
    public String logo;
    public int  followCinema;

    public Cinema(int id, String address, String name, String logo, int followCinema) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.logo = logo;
        this.followCinema = followCinema;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getFollowCinema() {
        return followCinema;
    }

    public void setFollowCinema(int followCinema) {
        this.followCinema = followCinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", followCinema=" + followCinema +
                '}';
    }
}
