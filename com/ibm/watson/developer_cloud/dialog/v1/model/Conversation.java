package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Conversation extends GenericModel {
    @SerializedName("client_id")
    private Integer clientId;
    private Double confidence;
    private String dialogId;
    @SerializedName("conversation_id")
    private Integer id;
    private String input;
    private List<String> response;

    public Integer getClientId() {
        return this.clientId;
    }

    public Double getConfidence() {
        return this.confidence;
    }

    public String getDialogId() {
        return this.dialogId;
    }

    public Integer getId() {
        return this.id;
    }

    public String getInput() {
        return this.input;
    }

    public List<String> getResponse() {
        return this.response;
    }

    public void setClientId(int clientId) {
        this.clientId = Integer.valueOf(clientId);
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public void setDialogId(String dialogId) {
        this.dialogId = dialogId;
    }

    public void setId(int id) {
        this.id = Integer.valueOf(id);
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }
}
