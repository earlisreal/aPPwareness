package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Ranking extends GenericModel {
    @SerializedName("answers")
    private List<RankedAnswer> answers;
    @SerializedName("ranker_id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("top_answer")
    private String topAnswer;
    @SerializedName("url")
    private String url;

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopAnswer(String topAnswer) {
        this.topAnswer = topAnswer;
    }

    public void setAnswers(List<RankedAnswer> answers) {
        this.answers = answers;
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public String getTopAnswer() {
        return this.topAnswer;
    }

    public List<RankedAnswer> getAnswers() {
        return this.answers;
    }
}
