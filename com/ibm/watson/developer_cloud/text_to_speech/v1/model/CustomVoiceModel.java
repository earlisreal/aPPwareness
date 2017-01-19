package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Date;

public class CustomVoiceModel extends GenericModel {
    private Date created;
    private String description;
    @SerializedName("customization_id")
    private String id;
    private String language;
    @SerializedName("last_modified")
    private Date lastModified;
    private String name;
    private String owner;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOwner() {
        return this.owner;
    }

    public Date getCreated() {
        return this.created;
    }

    public Date getLastModified() {
        return this.lastModified;
    }
}
