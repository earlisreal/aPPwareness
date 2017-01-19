package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;

public class DocumentEmotion extends AlchemyLanguageGenericModel {
    @SerializedName("docEmotions")
    private Emotion emotion;
    private String text;

    public Emotion getEmotion() {
        return this.emotion;
    }

    public String getText() {
        return this.text;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public void setText(String text) {
        this.text = text;
    }
}
