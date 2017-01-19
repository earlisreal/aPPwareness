package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Trait extends GenericModel {
    private String category;
    private List<Trait> children;
    private String id;
    private String name;
    private Double percentage;
    @SerializedName("raw_sampling_error")
    private Double rawSamplingError;
    @SerializedName("raw_score")
    private Double rawScore;
    @SerializedName("sampling_error")
    private Double samplingError;

    public String getCategory() {
        return this.category;
    }

    public List<Trait> getChildren() {
        return this.children;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPercentage() {
        return this.percentage;
    }

    public Double getRawSamplingError() {
        return this.rawSamplingError;
    }

    public Double getRawScore() {
        return this.rawScore;
    }

    public Double getSamplingError() {
        return this.samplingError;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setChildren(List<Trait> children) {
        this.children = children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setRawSamplingError(Double rawSamplingError) {
        this.rawSamplingError = rawSamplingError;
    }

    public void setRawScore(Double rawScore) {
        this.rawScore = rawScore;
    }

    public void setSamplingError(Double samplingError) {
        this.samplingError = samplingError;
    }
}
