package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;

public class ImageProcessingWarning {
    @SerializedName("description")
    private String description;
    @SerializedName("warning_id")
    private String warningId;

    public String getWarningId() {
        return this.warningId;
    }

    public void setWarningId(String warningId) {
        this.warningId = warningId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
