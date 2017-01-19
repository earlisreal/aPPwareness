package com.ibm.watson.developer_cloud.conversation.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;
import java.util.Map;

public class MessageRequest extends GenericModel {
    @SerializedName("alternate_intents")
    private Boolean alternateIntents;
    private Map<String, Object> context;
    private List<Entity> entities;
    private Map<String, Object> input;
    private List<Intent> intents;

    private MessageRequest(Builder options) {
        this.context = Builder.access$400(options);
        this.input = Builder.access$500(options);
        this.alternateIntents = Builder.access$600(options);
        this.entities = Builder.access$700(options);
        this.intents = Builder.access$800(options);
    }

    public Boolean alternateIntents() {
        return this.alternateIntents;
    }

    public Map<String, Object> context() {
        return this.context;
    }

    public Map<String, Object> input() {
        return this.input;
    }

    public List<Intent> intents() {
        return this.intents;
    }

    public List<Entity> entities() {
        return this.entities;
    }

    public String inputText() {
        return (this.input == null || this.input.get("text") == null) ? null : this.input.get("text").toString();
    }

    public Builder newBuilder() {
        return new Builder(this, null);
    }
}
