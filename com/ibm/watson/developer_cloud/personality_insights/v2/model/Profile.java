package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class Profile extends GenericModel {
    private String id;
    @SerializedName("processed_lang")
    private String processedLanguage;
    private String source;
    private Trait tree;
    @SerializedName("word_count")
    private int wordCount;
    @SerializedName("word_count_message")
    private String wordCountMessage;

    public String getId() {
        return this.id;
    }

    public String getProcessedLanguage() {
        return this.processedLanguage;
    }

    public String getSource() {
        return this.source;
    }

    public Trait getTree() {
        return this.tree;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public String getWordCountMessage() {
        return this.wordCountMessage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProcessedLanguage(String processedLanguage) {
        this.processedLanguage = processedLanguage;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTree(Trait tree) {
        this.tree = tree;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public void setWordCountMessage(String wordCountMessage) {
        this.wordCountMessage = wordCountMessage;
    }
}
