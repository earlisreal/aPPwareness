package com.ibm.watson.developer_cloud.language_translator.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class TranslationModel extends GenericModel {
    @SerializedName("base_model_id")
    private String baseModelId;
    private Boolean customizable;
    @SerializedName("default_model")
    private Boolean defaultModel;
    private String domain;
    @SerializedName("model_id")
    private String id;
    private String name;
    private String owner;
    private String source;
    private Status status;
    private String target;

    public String getBaseModelId() {
        return this.baseModelId;
    }

    public String getDomain() {
        return this.domain;
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

    public String getSource() {
        return this.source;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getTarget() {
        return this.target;
    }

    public boolean isCustomizable() {
        return this.customizable.booleanValue();
    }

    public boolean isDefaultModel() {
        return this.defaultModel.booleanValue();
    }

    public void setBaseModelId(String baseModelId) {
        this.baseModelId = baseModelId;
    }

    public void setCustomizable(boolean customizable) {
        this.customizable = Boolean.valueOf(customizable);
    }

    public void setDefaultModel(boolean defaultModel) {
        this.defaultModel = Boolean.valueOf(defaultModel);
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    public void setSource(String source) {
        this.source = source;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
