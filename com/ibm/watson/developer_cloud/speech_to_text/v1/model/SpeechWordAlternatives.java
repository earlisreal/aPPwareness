package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class SpeechWordAlternatives extends GenericModel {
    private List<WordAlternative> alternatives;
    @SerializedName("end_time")
    private Double endTime;
    @SerializedName("start_time")
    private Double startTime;

    public Double getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public List<WordAlternative> getAlternatives() {
        return this.alternatives;
    }

    public void setAlternatives(List<WordAlternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Double getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }
}
