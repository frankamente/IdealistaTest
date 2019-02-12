package com.example.demo;

public class Foto {
    private int id;
    private String url;
    private String quality;

    public Foto() {
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
        return "Foto{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
