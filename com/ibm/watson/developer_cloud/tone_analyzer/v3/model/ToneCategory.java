package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class ToneCategory extends GenericModel {
    @SerializedName("category_id")
    private String id;
    @SerializedName("category_name")
    private String name;
    private List<ToneScore> tones;

    public void addTone(ToneScore score) {
        this.tones.add(score);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<ToneScore> getTones() {
        return this.tones;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTones(List<ToneScore> tones) {
        this.tones = tones;
    }
}
