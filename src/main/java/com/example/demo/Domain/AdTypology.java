package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

class AdTypology {
    private final AdTypologyEnum adTypologyEnum;
    @JsonIgnore
    private final TypologyScoreBehaviour typologyScoreBehaviour;

    AdTypology(AdTypologyEnum adTypologyEnum, TypologyScoreBehaviour typologyScoreBehaviour){
        this.adTypologyEnum = adTypologyEnum;

        this.typologyScoreBehaviour = typologyScoreBehaviour;
    }

    int getScore(AdDescription adDescription) {
        return typologyScoreBehaviour.getScore(adDescription);
    }

    public AdTypologyEnum getAdTypologyEnum() {
        return adTypologyEnum;
    }
}
