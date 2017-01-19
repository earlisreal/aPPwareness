package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class ElementTone extends GenericModel {
    @SerializedName("tone_categories")
    private List<ToneCategory> tones;

    public void addTone(ToneCategory tone) {
        this.tones.add(tone);
    }

    public List<ToneCategory> getTones() {
        return this.tones;
    }

    public void setTones(List<ToneCategory> tones) {
        this.tones = tones;
    }
}
