package com.example.demo.Domain;

public enum AdTypologyEnum {

    CHALET,
    FLAT,
    GARAGE;

    public static AdTypologyEnum getEnumFromString(String string) {
        if( string != null ) {
            try {
                return AdTypologyEnum.valueOf(string.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {
            }
        }
        return null;
    }
}
