package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class SpeechResults extends GenericModel {
    @SerializedName("result_index")
    private int resultIndex;
    private List<Transcript> results;
    @SerializedName("speaker_labels")
    private List<SpeakerLabel> speakerLabels;

    public List<SpeakerLabel> getSpeakerLabels() {
        return this.speakerLabels;
    }

    public void setSpeakerLabels(List<SpeakerLabel> speakerLabels) {
        this.speakerLabels = speakerLabels;
    }

    public int getResultIndex() {
        return this.resultIndex;
    }

    public List<Transcript> getResults() {
        return this.results;
    }

    public boolean isFinal() {
        return this.results != null && this.resultIndex < this.results.size() && this.results.get(this.resultIndex) != null && ((Transcript) this.results.get(this.resultIndex)).isFinal();
    }

    public void setResultIndex(int resultIndex) {
        this.resultIndex = resultIndex;
    }

    public void setResults(List<Transcript> results) {
        this.results = results;
    }
}
