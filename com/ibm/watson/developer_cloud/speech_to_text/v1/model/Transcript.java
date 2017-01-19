package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;
import java.util.Map;

public class Transcript extends GenericModel {
    private List<SpeechAlternative> alternatives;
    @SerializedName("final")
    private boolean ffinal;
    @SerializedName("keywords_result")
    private Map<String, List<KeywordsResult>> keywordsResult;
    @SerializedName("word_alternatives")
    private List<SpeechWordAlternatives> wordAlternatives;

    public List<SpeechAlternative> getAlternatives() {
        return this.alternatives;
    }

    public boolean isFinal() {
        return this.ffinal;
    }

    public void setAlternatives(List<SpeechAlternative> alternatives) {
        this.alternatives = alternatives;
    }

    public void setFinal(boolean finalValue) {
        this.ffinal = finalValue;
    }

    public Map<String, List<KeywordsResult>> getKeywordsResult() {
        return this.keywordsResult;
    }

    public void setKeywordsResult(Map<String, List<KeywordsResult>> keywordsResult) {
        this.keywordsResult = keywordsResult;
    }

    public List<SpeechWordAlternatives> getWordAlternatives() {
        return this.wordAlternatives;
    }

    public void setWordAlternatives(List<SpeechWordAlternatives> wordAlternatives) {
        this.wordAlternatives = wordAlternatives;
    }
}
