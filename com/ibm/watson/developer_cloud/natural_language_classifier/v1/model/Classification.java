package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Classification extends GenericModel {
    private List<ClassifiedClass> classes;
    @SerializedName("classifier_id")
    private String id;
    private String text;
    @SerializedName("top_class")
    private String topClass;
    private String url;

    public List<ClassifiedClass> getClasses() {
        return this.classes;
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public String getTopClass() {
        return this.topClass;
    }

    public String getUrl() {
        return this.url;
    }

    public void setClasses(List<ClassifiedClass> classes) {
        this.classes = classes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTopClass(String topClass) {
        this.topClass = topClass;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
