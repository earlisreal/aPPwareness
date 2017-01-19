package com.ibm.watson.developer_cloud.personality_insights.v2.model;

public enum AcceptLanguage {
    ENGLISH("en"),
    SPANISH("es"),
    ARABIC("ar"),
    JAPANESE("ja");
    
    private final String text;

    private AcceptLanguage(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
