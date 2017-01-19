package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.LongToDateTypeAdapter;
import java.util.Date;

public class ContentItem extends GenericModel {
    private String charset;
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
    @SerializedName("sourceid")
    private String sourceId;
    @JsonAdapter(LongToDateTypeAdapter.class)
    private Date updated;
    @SerializedName("userid")
    private String userId;

    @Deprecated
    public ContentItem charset(String charset) {
        this.charset = charset;
        return this;
    }

    @Deprecated
    public ContentItem content(String content) {
        this.content = content;
        return this;
    }

    @Deprecated
    public ContentItem contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    @Deprecated
    public ContentItem created(Date created) {
        this.created = created;
        return this;
    }

    @Deprecated
    public ContentItem forward(boolean forward) {
        this.forward = Boolean.valueOf(forward);
        return this;
    }

    public String getCharset() {
        return this.charset;
    }

    public String getContent() {
        return this.content;
    }

    @Deprecated
    public String getContenttype() {
        return this.contentType;
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

    @Deprecated
    public String getParentid() {
        return this.parentId;
    }

    @Deprecated
    public String getSourceid() {
        return this.sourceId;
    }

    public Date getUpdated() {
        return this.updated;
    }

    @Deprecated
    public String getUserid() {
        return this.userId;
    }

    @Deprecated
    public ContentItem id(String id) {
        this.id = id;
        return this;
    }

    public boolean isForward() {
        return this.forward.booleanValue();
    }

    public boolean isReply() {
        return this.reply.booleanValue();
    }

    @Deprecated
    public ContentItem language(String language) {
        this.language = language;
        return this;
    }

    @Deprecated
    public ContentItem parentid(String parentId) {
        this.parentId = parentId;
        return this;
    }

    @Deprecated
    public ContentItem reply(boolean reply) {
        this.reply = Boolean.valueOf(reply);
        return this;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Deprecated
    public void setContenttype(String contentType) {
        this.contentType = contentType;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setForward(boolean forward) {
        this.forward = Boolean.valueOf(forward);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Deprecated
    public void setParentid(String parentId) {
        this.parentId = parentId;
    }

    public void setReply(boolean reply) {
        this.reply = Boolean.valueOf(reply);
    }

    @Deprecated
    public void setSourceid(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Deprecated
    public void setUserid(String userId) {
        this.userId = userId;
    }

    @Deprecated
    public ContentItem sourceid(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    @Deprecated
    public ContentItem updated(Date updated) {
        this.updated = updated;
        return this;
    }

    @Deprecated
    public ContentItem userid(String userId) {
        this.userId = userId;
        return this;
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

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
