package com.example.demo.Domain;

public class NoPictureScoreFilter implements ScoreFilter {
    private final int NO_PICTURE = -10;
    private final int HAS_PICTURE_SCORE = 0;
    @Override
    public int getFilterScore(AdDTO adDTO) {
        return adDTO.getPictureSet().isEmpty() ? NO_PICTURE : HAS_PICTURE_SCORE;
    }
}
