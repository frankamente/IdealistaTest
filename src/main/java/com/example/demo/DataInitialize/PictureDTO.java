package com.example.demo.DataInitialize;

public class PictureDTO {
    private int id;
    private String url;
    private String quality;

    public PictureDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "PictureDTO{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
