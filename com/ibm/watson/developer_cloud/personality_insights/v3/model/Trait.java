package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Trait extends GenericModel {
    private String category;
    private List<Trait> children;
    private String name;
    private Double percentile;
    @SerializedName("raw_score")
    private Double rawScore;
    @SerializedName("trait_id")
    private String traitId;

    public Double getRawScore() {
        return this.rawScore;
    }

    public void setRawScore(Double rawScore) {
        this.rawScore = rawScore;
    }

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

    public Double getPercentile() {
        return this.percentile;
    }

    public void setPercentile(Double percentile) {
        this.percentile = percentile;
    }

    public List<Trait> getChildren() {
        return this.children;
    }

    public void setChildren(List<Trait> children) {
        this.children = children;
    }
}
