package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;

public class ImageProcessingError {
    private String description;
    @SerializedName("error_id")
    private String errorId;

    public String getErrorId() {
        return this.errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
