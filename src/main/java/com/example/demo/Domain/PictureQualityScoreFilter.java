package com.example.demo.Domain;

public class PictureQualityScoreFilter implements ScoreFilter {
    @Override
    public int getFilterScore(AdDTO adDTO) {
        return adDTO.getPictureSet().stream().mapToInt(this::getPictureScore).sum();
    }

    private int getPictureScore(PictureDTO pictureDTO) {
        return pictureDTO.getQuality().getScore();
    }
}
