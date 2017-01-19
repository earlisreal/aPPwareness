package com.ibm.watson.developer_cloud.language_translation.v2.model;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class Translation extends GenericModel {
    @Expose
    private String translation;

    public String getTranslation() {
        return this.translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
