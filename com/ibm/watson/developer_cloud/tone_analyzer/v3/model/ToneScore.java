package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class ToneScore extends GenericModel {
    @SerializedName("tone_id")
    private String id;
    @SerializedName("tone_name")
    private String name;
    private Double score;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getScore() {
        return this.score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
