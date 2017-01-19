package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.LongToDateTypeAdapter;
import java.util.Date;

public class ContentItem extends GenericModel {
    private String content;
    @SerializedName("contenttype")
    private String contentType;
    @JsonAdapter(LongToDateTypeAdapter.class)
    private Date created;
    private Boolean forward;
    private String id;
    private String language;
    @SerializedName("parentid")
    private String parentId;
    private Boolean reply;
    @JsonAdapter(LongToDateTypeAdapter.class)
    private Date updated;

    public String getContent() {
        return this.content;
    }

    public Date getCreated() {
        return this.created;
    }

    public String getId() {
        return this.id;
    }

    public String getLanguage() {
        return this.language;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public boolean isForward() {
        return this.forward.booleanValue();
    }

    public boolean isReply() {
        return this.reply.booleanValue();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setForward(Boolean forward) {
        this.forward = forward;
    }

    public void setReply(Boolean reply) {
        this.reply = reply;
    }
}
