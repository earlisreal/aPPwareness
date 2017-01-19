package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class Corpus extends GenericModel {
    private String error;
    private String name;
    @SerializedName("out_of_vocabulary_words")
    private Integer outOfVocabularyWords;
    private Status status;
    @SerializedName("total_words")
    private Integer totalWords;

    public enum Status {
        ANALYZED,
        BEING_PROCESSED,
        UNDETERMINED
    }

    public String getError() {
        return this.error;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOutOfVocabularyWords() {
        return this.outOfVocabularyWords;
    }

    public Status getStatus() {
        return this.status;
    }

    public Integer getTotalWords() {
        return this.totalWords;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOutOfVocabularyWords(Integer outOfVocabularyWOrds) {
        this.outOfVocabularyWords = outOfVocabularyWOrds;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTotalWords(Integer totalWords) {
        this.totalWords = totalWords;
    }
}
