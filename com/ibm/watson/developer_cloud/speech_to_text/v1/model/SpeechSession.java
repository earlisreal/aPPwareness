package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class SpeechSession extends GenericModel {
    @SerializedName("new_session_uri")
    private String newSessionUri;
    @SerializedName("observe_result")
    private String observeResult;
    private String recognize;
    private String recognizeWS;
    @SerializedName("session_id")
    private String sessionId;

    public String getNewSessionUri() {
        return this.newSessionUri;
    }

    public String getObserveResult() {
        return this.observeResult;
    }

    public String getRecognize() {
        return this.recognize;
    }

    public String getRecognizeWS() {
        return this.recognizeWS;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setNewSessionUri(String newSessionUri) {
        this.newSessionUri = newSessionUri;
    }

    public void setObserveResult(String observeResult) {
        this.observeResult = observeResult;
    }

    public void setRecognize(String recognize) {
        this.recognize = recognize;
    }

    public void setRecognizeWS(String recognizeWS) {
        this.recognizeWS = recognizeWS;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
