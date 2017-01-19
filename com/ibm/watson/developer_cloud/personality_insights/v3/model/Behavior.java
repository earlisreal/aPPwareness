package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class Behavior extends GenericModel {
    private String category;
    private String name;
    private Double percentage;
    @SerializedName("trait_id")
    private String traitId;

    public String getTraitId() {
        return this.traitId;
    }

    public void setTraitId(String traitId) {
        this.traitId = traitId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
