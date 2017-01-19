package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.BooleanToStringTypeAdapter;

public class Taxonomy extends GenericModel {
    @JsonAdapter(BooleanToStringTypeAdapter.class)
    private Boolean confident;
    private String label;
    private Double score;

    public Taxonomy() {
        this.confident = Boolean.valueOf(true);
    }

    public Boolean getConfident() {
        return this.confident;
    }

    public String getLabel() {
        return this.label;
    }

    public Double getScore() {
        return this.score;
    }

    public void setConfident(Boolean confident) {
        this.confident = confident;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
