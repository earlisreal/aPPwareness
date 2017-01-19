package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.LongToDateTypeAdapter;
import java.util.Date;

public class Document extends GenericModel {
    private String id;
    private Source source;
    @JsonAdapter(LongToDateTypeAdapter.class)
    private Date timestamp;

    public String getId() {
        return this.id;
    }

    public Source getSource() {
        return this.source;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
