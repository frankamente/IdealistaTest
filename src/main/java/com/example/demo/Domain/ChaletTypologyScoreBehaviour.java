package com.example.demo.Domain;

public class ChaletTypologyScoreBehaviour implements TypologyScoreBehaviour {
    private final int MORE_THAN_20_WORDS_SCORE = 10;
    private final int MORE_THAN_50_WORDS_SCORE = 30;
    private final int BONUS_CHALET = 20;

    @Override
    public int getScore(AdDescription adDescription) {
        int score = 0;
        if (adDescription.hasEqualsOrMoreThanNumberWords(20)) {
            score += MORE_THAN_20_WORDS_SCORE;
        }
        if(adDescription.hasEqualsOrMoreThanNumberWords(50)) {
            score += MORE_THAN_50_WORDS_SCORE;
            score += BONUS_CHALET;
        }
        return score;
    }
}
