package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class KeywordsResult extends GenericModel {
    private Double confidence;
    @SerializedName("end_time")
    private Double endTime;
    @SerializedName("normalized_text")
    private String normalizedText;
    @SerializedName("start_time")
    private Double startTime;

    public String getNormalizedText() {
        return this.normalizedText;
    }

    public void setNormalizedText(String normalizedText) {
        this.normalizedText = normalizedText;
    }

    public Double getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public Double getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public Double getConfidence() {
        return this.confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
