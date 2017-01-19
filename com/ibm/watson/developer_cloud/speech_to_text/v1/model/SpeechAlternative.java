package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class SpeechAlternative extends GenericModel {
    private Double confidence;
    private List<SpeechTimestamp> timestamps;
    private String transcript;
    @SerializedName("word_confidence")
    private List<SpeechWordConfidence> wordConfidences;

    public Double getConfidence() {
        return this.confidence;
    }

    public List<SpeechTimestamp> getTimestamps() {
        return this.timestamps;
    }

    public String getTranscript() {
        return this.transcript;
    }

    public List<SpeechWordConfidence> getWordConfidences() {
        return this.wordConfidences;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public void setTimestamps(List<SpeechTimestamp> timestamps) {
        this.timestamps = timestamps;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public void setWordConfidences(List<SpeechWordConfidence> wordConfidences) {
        this.wordConfidences = wordConfidences;
    }
}
