package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Date;
import java.util.List;

public class VisualClassifier extends GenericModel {
    private List<VisualClass> classes;
    private Date created;
    private String explanation;
    @SerializedName("classifier_id")
    private String id;
    private String name;
    private String owner;
    private Status status;

    public enum Status {
        AVAILABLE,
        FAILED,
        NON_EXISTENT,
        TRAINING,
        UNAVAILABLE
    }

    public class VisualClass {
        @SerializedName("class")
        private String name;
        private Double score;
        @SerializedName("type_hierarchy")
        private String typeHierarchy;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getScore() {
            return this.score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public String getTypeHierarchy() {
            return this.typeHierarchy;
        }

        public void setTypeHierarchy(String typeHierarchy) {
            this.typeHierarchy = typeHierarchy;
        }
    }

    public String getExplanation() {
        return this.explanation;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Date getCreated() {
        return this.created;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<VisualClass> getClasses() {
        return this.classes;
    }

    public void setClasses(List<VisualClass> classes) {
        this.classes = classes;
    }
}
