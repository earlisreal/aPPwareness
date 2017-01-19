package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.HashMap;
import java.util.Map;

public class Option extends GenericModel {
    @SerializedName("app_data")
    private Map<String, String> appData;
    @SerializedName("description_html")
    private String descriptionHtml;
    private String key;
    private String name;
    private HashMap<String, Object> values;

    public Option(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public Option(String key, String name, HashMap<String, Object> values, String descriptionHtml) {
        this.key = key;
        this.name = name;
        this.values = values;
        this.descriptionHtml = descriptionHtml;
    }

    public Option appData(HashMap<String, String> appData) {
        this.appData = appData;
        return this;
    }

    public Option descriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public String getDescriptionHtml() {
        return this.descriptionHtml;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, Object> getValues() {
        return this.values;
    }

    public Option key(String key) {
        this.key = key;
        return this;
    }

    public Option name(String name) {
        this.name = name;
        return this;
    }

    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValues(HashMap<String, Object> values) {
        this.values = values;
    }

    public Option value(String name, Object value) {
        if (this.values == null) {
            this.values = new HashMap();
        }
        this.values.put(name, value);
        return this;
    }

    public Option values(HashMap<String, Object> values) {
        this.values = values;
        return this;
    }
}
