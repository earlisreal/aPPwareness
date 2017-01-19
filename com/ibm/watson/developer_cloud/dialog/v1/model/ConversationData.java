package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class ConversationData extends GenericModel {
    @SerializedName("client_id")
    private Integer clientId;
    @SerializedName("conversation_id")
    private Integer conversationId;
    @SerializedName("hit_nodes")
    private List<HitNode> hitNodes;
    private List<Message> messages;
    private List<NameValue> profile;

    public int getClientId() {
        return this.clientId.intValue();
    }

    public Integer getConversationId() {
        return this.conversationId;
    }

    public List<HitNode> getHitNodes() {
        return this.hitNodes;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public List<NameValue> getProfile() {
        return this.profile;
    }

    public void setClientId(int clientId) {
        this.clientId = Integer.valueOf(clientId);
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public void setHitNodes(List<HitNode> hitNodes) {
        this.hitNodes = hitNodes;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setProfile(List<NameValue> profile) {
        this.profile = profile;
    }
}
