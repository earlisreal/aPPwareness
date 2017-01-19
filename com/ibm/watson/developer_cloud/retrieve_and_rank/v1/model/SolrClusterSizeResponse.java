package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class SolrClusterSizeResponse extends GenericModel {
    @SerializedName("cluster_id")
    private final String clusterId;
    @SerializedName("cluster_size")
    private final Integer currentSize;
    @SerializedName("message")
    private final String message;
    @SerializedName("status")
    private final Status status;
    @SerializedName("target_cluster_size")
    private final Integer targetSize;

    public SolrClusterSizeResponse(String clusterId, Integer currentSize, Integer targetSize, String message, Status status) {
        this.clusterId = clusterId;
        this.status = status;
        this.currentSize = currentSize;
        this.targetSize = targetSize;
        this.message = message;
    }

    public SolrClusterSizeResponse(String clusterId, Integer currentSize, String message) {
        this.clusterId = clusterId;
        this.status = null;
        this.currentSize = currentSize;
        this.targetSize = null;
        this.message = message;
    }

    @SerializedName("cluster_id")
    public String geClusterId() {
        return this.clusterId;
    }

    @SerializedName("status")
    public Status getStatus() {
        return this.status;
    }

    @SerializedName("cluster_size")
    public Integer getCurrentSize() {
        return this.currentSize;
    }

    @SerializedName("target_cluster_size")
    public Integer getTargetSize() {
        return this.targetSize;
    }

    @SerializedName("message")
    public String getMessage() {
        return this.message;
    }
}
