package com.example.demo.Domain;

public class NoTypologyScoreBehaviour implements TypologyScoreBehaviour {
    @Override
    public int getScore(AdDescription adDescription) {
        return 0;
    }
}
