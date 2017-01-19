package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;

public class SentenceTone extends ElementTone {
    @SerializedName("sentence_id")
    private Integer id;
    @SerializedName("input_from")
    private Integer inputFrom;
    @SerializedName("input_to")
    private Integer inputTo;
    @SerializedName("text")
    private String text;

    public Integer getId() {
        return this.id;
    }

    public Integer getInputFrom() {
        return this.inputFrom;
    }

    public Integer getInputTo() {
        return this.inputTo;
    }

    public String getText() {
        return this.text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInputFrom(Integer inputFrom) {
        this.inputFrom = inputFrom;
    }

    public void setInputTo(Integer inputTo) {
        this.inputTo = inputTo;
    }

    public void setText(String text) {
        this.text = text;
    }
}
