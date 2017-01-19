package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;

public class DocumentSentiment extends AlchemyLanguageGenericModel {
    @SerializedName("docSentiment")
    private Sentiment sentiment;
    private String text;

    public Sentiment getSentiment() {
        return this.sentiment;
    }

    public String getText() {
        return this.text;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    public void setText(String text) {
        this.text = text;
    }
}
