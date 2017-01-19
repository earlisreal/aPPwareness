package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;

public class DocumentsResult extends AlchemyGenericModel {
    @SerializedName("result")
    private Documents documents;

    public Documents getDocuments() {
        return this.documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }
}
