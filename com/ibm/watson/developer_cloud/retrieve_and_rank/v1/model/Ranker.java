package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Date;

public class Ranker extends GenericModel {
    private Date created;
    @SerializedName("ranker_id")
    private String id;
    private String name;
    private Status status;
    @SerializedName("status_description")
    private String statusDescription;
    private String url;

    public enum Status {
        AVAILABLE,
        FAILED,
        NON_EXISTENT,
        TRAINING,
        UNAVAILABLE
    }

    public Date getCreated() {
        return this.created;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
