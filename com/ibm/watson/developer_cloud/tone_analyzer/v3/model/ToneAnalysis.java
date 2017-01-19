package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class ToneAnalysis extends GenericModel {
    @SerializedName("document_tone")
    private ElementTone documentTone;
    @SerializedName("sentences_tone")
    private List<SentenceTone> sentencesTone;

    public void addSentencesTone(SentenceTone analysis) {
        this.sentencesTone.add(analysis);
    }

    public ElementTone getDocumentTone() {
        return this.documentTone;
    }

    public List<SentenceTone> getSentencesTone() {
        return this.sentencesTone;
    }

    public void setDocumentTone(ElementTone documentTone) {
        this.documentTone = documentTone;
    }

    public void setSentencesTone(List<SentenceTone> sentencesTone) {
        this.sentencesTone = sentencesTone;
    }
}
