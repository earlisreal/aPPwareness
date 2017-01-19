package com.ibm.watson.developer_cloud.personality_insights.v3.model;

public enum Language {
    ENGLISH("en"),
    SPANISH("es"),
    ARABIC("ar"),
    JAPANESE("ja");
    
    private final String text;

    private Language(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
