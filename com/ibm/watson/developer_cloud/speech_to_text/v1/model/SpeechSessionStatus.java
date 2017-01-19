package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class SpeechSessionStatus extends GenericModel {
    private String model;
    @SerializedName("observe_result")
    private String observeResult;
    private String recognize;
    private String state;

    public String getModel() {
        return this.model;
    }

    public String getObserveResult() {
        return this.observeResult;
    }

    public String getRecognize() {
        return this.recognize;
    }

    public String getState() {
        return this.state;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setObserveResult(String observeResult) {
        this.observeResult = observeResult;
    }

    public void setRecognize(String recognize) {
        this.recognize = recognize;
    }

    public void setState(String state) {
        this.state = state;
    }
}
