package com.example.demo.Domain;

public class HasDescriptionScoreFilter implements ScoreFilter {
    private final int NO_DESCRIPTION_SCORE = 0;
    private final int HAS_DESCRIPTION_SCORE = 5;
    @Override
    public int getFilterScore(AdDTO adDTO) {
        final AdDescription description = adDTO.getAdDescription();
        if (!description.hasValue()) {
            return NO_DESCRIPTION_SCORE;
        }
        return HAS_DESCRIPTION_SCORE;
    }
}
