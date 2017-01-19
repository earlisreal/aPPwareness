package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class HitNode extends GenericModel {
    private String details;
    private String label;
    @SerializedName("node_id")
    private Integer nodeId;
    private String type;

    public String getDetails() {
        return this.details;
    }

    public String getLabel() {
        return this.label;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public String getType() {
        return this.type;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public void setType(String type) {
        this.type = type;
    }
}
