package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class ClassifiedClass extends GenericModel {
    private Double confidence;
    @SerializedName("class_name")
    private String name;

    public Double getConfidence() {
        return this.confidence;
    }

    public String getName() {
        return this.name;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public void setName(String name) {
        this.name = name;
    }
}
