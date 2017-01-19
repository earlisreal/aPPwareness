package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;

public class ImageProcessed {
    private ImageProcessingError error;
    private String image;
    @SerializedName("resolved_url")
    private String resolvedUrl;
    @SerializedName("source_url")
    private String sourceUrl;

    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getResolvedUrl() {
        return this.resolvedUrl;
    }

    public void setResolvedUrl(String resolvedUrl) {
        this.resolvedUrl = resolvedUrl;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageProcessingError getError() {
        return this.error;
    }

    public void setError(ImageProcessingError error) {
        this.error = error;
    }
}
