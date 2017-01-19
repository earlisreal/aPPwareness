package com.ibm.watson.developer_cloud.personality_insights.v3.model;

public enum AcceptLanguage {
    ARABIC("ar"),
    ENGLISH("en"),
    SPANISH("es"),
    JAPANESE("ja"),
    BRAZILIAN_PORTUGUESE("pt-br"),
    FRENCH("fr"),
    GERMAN("de"),
    ITALIAN("it"),
    KOREAN("ko"),
    SIMPLIFIED_CHINESE("zh-cn"),
    TRADITIONAL_CHINESE("zh-tw");
    
    private final String text;

    private AcceptLanguage(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
