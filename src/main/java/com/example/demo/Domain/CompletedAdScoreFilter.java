package com.example.demo.Domain;

public class CompletedAdScoreFilter implements ScoreFilter {
    private final int COMPLETED_AD_SCORE = 40;
    private final int INCOMPLETED_AD_SCORE = 0;

    @Override
    public int getFilterScore(AdDTO adDTO) {
        return adDTO.isComplete() ? COMPLETED_AD_SCORE : INCOMPLETED_AD_SCORE;
    }
}
