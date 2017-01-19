package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Documents extends GenericModel {
    @SerializedName("docs")
    private List<Document> documents;
    private String next;

    public List<Document> getDocuments() {
        return this.documents;
    }

    public String getNext() {
        return this.next;
    }

    public void setDocs(List<Document> docs) {
        this.documents = docs;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
