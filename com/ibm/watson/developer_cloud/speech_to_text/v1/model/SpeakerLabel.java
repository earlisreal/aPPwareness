package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;

public class SpeakerLabel {
    @SerializedName("final")
    private boolean ffinal;
    private Double from;
    private int speaker;
    private Double to;

    public Double getFrom() {
        return this.from;
    }

    public void setFrom(Double from) {
        this.from = from;
    }

    public Double getTo() {
        return this.to;
    }

    public void setTo(Double to) {
        this.to = to;
    }

    public int getSpeaker() {
        return this.speaker;
    }

    public void setSpeaker(int speaker) {
        this.speaker = speaker;
    }

    public boolean isFinal() {
        return this.ffinal;
    }

    public void setFinal(boolean ffinal) {
        this.ffinal = ffinal;
    }
}
