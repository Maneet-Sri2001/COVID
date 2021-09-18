package com.example.covid;

public class newsModel {

    String auth, name, tiltle, url, imgUrl;

    public newsModel(String auth, String name, String tiltle, String url, String imgUrl) {
        this.auth = auth;
        this.name = name;
        this.tiltle = tiltle;
        this.url = url;
        this.imgUrl = imgUrl;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
