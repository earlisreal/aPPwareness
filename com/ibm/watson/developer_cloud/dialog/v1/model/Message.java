package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Date;

public class Message extends GenericModel {
    @SerializedName("date_time")
    private Date dateTime;
    @SerializedName("from_client")
    private String fromClient;
    private String text;

    public Date getDateTime() {
        return this.dateTime;
    }

    public String getFromClient() {
        return this.fromClient;
    }

    public String getText() {
        return this.text;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setFromClient(String fromClient) {
        this.fromClient = fromClient;
    }

    public void setText(String text) {
        this.text = text;
    }
}
