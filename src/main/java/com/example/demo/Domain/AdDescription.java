package com.example.demo.Domain;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdDescription {
    private final int CONTAINS_SPECIFIC_WORD_SCORE = 5;
    private List<String> specificWords;
    private final String description;

    public AdDescription(String description) {

        this.description = description;
        initializeSpecificWords();
    }

    private void initializeSpecificWords() {
        specificWords = new ArrayList<>();
        specificWords.add("Luminoso");
        specificWords.add("Nuevo");
        specificWords.add("Céntrico");
        specificWords.add("Reformado");
        specificWords.add("Ático");
    }

    public boolean hasValue() {
        return description != null && !description.isEmpty();
    }

    public boolean hasEqualsOrMoreThanNumberWords(int number) {
        return getDescriptionWords() >= number;
    }

    private int getDescriptionWords() {

        return getDescriptionWordsList().size();
    }

    private List<String> getDescriptionWordsList() {
        return Arrays.asList(description.split("\\s+"));
    }

    public String getDescription() {
        return description;
    }

    int getSpecificWordsScore() {
        int score = 0;
        List<String> descriptionWordsList = getDescriptionWordsList();
        for (String descriptionWord : descriptionWordsList) {
            for (String specificWord : specificWords) {
                if (contains(descriptionWord, specificWord)) {
                    score += CONTAINS_SPECIFIC_WORD_SCORE;
                }
            }
        }
        return score;
    }

    private boolean contains(String descriptionWord, String specificWord) {
        return removeDiacriticalMarks(descriptionWord).toLowerCase().contains(removeDiacriticalMarks(specificWord).toLowerCase());
    }

    private String removeDiacriticalMarks(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
