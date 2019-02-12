package com.example.demo.Domain;

public class DescriptionSizeScoreFilter implements ScoreFilter {
    @Override
    public int getFilterScore(AdDTO adDTO) {
        return adDTO.getAdTypology().getScore(adDTO.getAdDescription());
    }
}
