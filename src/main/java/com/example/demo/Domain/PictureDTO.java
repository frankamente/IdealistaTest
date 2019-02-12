package com.example.demo.Domain;

import java.util.Objects;

public class PictureDTO {
    private int id;
    private String url;
    private PictureQuality quality;

    public PictureDTO() {
    }

    public PictureDTO(com.example.demo.DataInitialize.PictureDTO pictureDTO) {
        this.id = pictureDTO.getId();
        this.url = pictureDTO.getUrl();
        this.quality = getPhotoQuality(pictureDTO.getQuality());
    }

    private PictureQuality getPhotoQuality(String quality) {
        return PictureQuality.getEnumFromString(quality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PictureDTO that = (PictureDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public PictureQuality getQuality() {
        return quality;
    }

    public void setQuality(PictureQuality quality) {
        this.quality = quality;
    }
}
