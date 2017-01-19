package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.SpeechWordConfidenceTypeAdapter;

@JsonAdapter(SpeechWordConfidenceTypeAdapter.class)
public class SpeechWordConfidence extends GenericModel {
    private Double confidence;
    private String word;

    public Double getConfidence() {
        return this.confidence;
    }

    public String getWord() {
        return this.word;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
