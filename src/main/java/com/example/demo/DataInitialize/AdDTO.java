package com.example.demo.DataInitialize;

import java.util.Arrays;

public class AdDTO {

    private int id;
    private String description;
    private String typology;
    private int houseSize;
    private int gardenSize;
    private int[] pictures;

    public AdDTO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public int getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(int houseSize) {
        this.houseSize = houseSize;
    }

    public int getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(int gardenSize) {
        this.gardenSize = gardenSize;
    }

    public int[] getPictures() {
        return pictures;
    }

    public void setPictures(int[] pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "AdDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", typology='" + typology + '\'' +
                ", houseSize=" + houseSize +
                ", gardenSize=" + gardenSize +
                ", pictures=" + Arrays.toString(pictures) +
                '}';
    }
}
