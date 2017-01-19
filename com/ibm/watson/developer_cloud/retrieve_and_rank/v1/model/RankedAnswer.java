package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class RankedAnswer extends GenericModel {
    @SerializedName("answer_id")
    private String answerID;
    @SerializedName("confidence")
    private Double confidence;
    @SerializedName("score")
    private Double score;

    public String getAnswerID() {
        return this.answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getConfidence() {
        return this.confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
