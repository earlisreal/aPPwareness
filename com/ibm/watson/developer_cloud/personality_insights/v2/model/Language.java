package com.ibm.watson.developer_cloud.personality_insights.v2.model;

public enum Language {
    ENGLISH("en"),
    SPANISH("es");
    
    private final String text;

    private Language(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
