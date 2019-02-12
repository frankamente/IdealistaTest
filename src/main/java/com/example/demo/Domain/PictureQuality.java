package com.example.demo.Domain;

public enum PictureQuality {
    SD(10),
    HD(20);

    private final int score;

    PictureQuality(final int score) {
        this.score = score;
    }

    public static PictureQuality getEnumFromString(String string) {
        if( string != null ) {
            try {
                return PictureQuality.valueOf(string.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {
            }
        }
        return null;
    }

    public int getScore() {
        return score;
    }
}

