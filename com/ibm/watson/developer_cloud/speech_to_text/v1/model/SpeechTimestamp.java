package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.SpeechTimestampTypeAdapter;

@JsonAdapter(SpeechTimestampTypeAdapter.class)
public class SpeechTimestamp extends GenericModel {
    private Double endTime;
    private Double startTime;
    private String word;

    public Double getEndTime() {
        return this.endTime;
    }

    public Double getStartTime() {
        return this.startTime;
    }

    public String getWord() {
        return this.word;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
