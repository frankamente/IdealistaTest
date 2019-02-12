package com.example.demo.Domain;

public class SpecificWordsScoreFilter implements ScoreFilter {
    @Override
    public int getFilterScore(AdDTO adDTO) {
        return adDTO.getAdDescription().getSpecificWordsScore();
    }
}
