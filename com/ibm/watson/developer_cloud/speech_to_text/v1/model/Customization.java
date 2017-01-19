package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Date;

public class Customization extends GenericModel {
    @SerializedName("base_model_name")
    private String baseModelName;
    private Date created;
    @SerializedName("customization_id")
    private String customizationId;
    private String description;
    private String language;
    private String name;
    private String owner;
    private Integer progress;
    private Status status;
    private String warnings;

    public enum Status {
        PENDING,
        READY,
        TRAINING,
        FAILED,
        AVAILABLE
    }

    public String getId() {
        return this.customizationId;
    }

    public void setId(String customizationId) {
        this.customizationId = customizationId;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseModelName() {
        return this.baseModelName;
    }

    public void setBaseModelName(String baseModelName) {
        this.baseModelName = baseModelName;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getWarnings() {
        return this.warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }
}
