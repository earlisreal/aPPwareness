package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Date;
import java.util.List;

public class RecognitionJob extends GenericModel {
    private Date created;
    private String id;
    private List<SpeechResults> results;
    private Status status;
    private Date updated;
    private String url;
    @SerializedName("user_token")
    private String userToken;

    public enum Status {
        COMPLETED,
        FAILED,
        PROCESSING,
        WAITING
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getId() {
        return this.id;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<SpeechResults> getResults() {
        return this.results;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setResults(List<SpeechResults> results) {
        this.results = results;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
