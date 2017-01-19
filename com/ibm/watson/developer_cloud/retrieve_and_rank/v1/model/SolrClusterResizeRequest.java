package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.util.Validator;

public class SolrClusterResizeRequest {
    @SerializedName("cluster_size")
    private final int clusterSize;

    public SolrClusterResizeRequest(int clusterSize) {
        Validator.isTrue(clusterSize > 0, "clusterSize cannot be lower than 0");
        this.clusterSize = clusterSize;
    }

    @SerializedName("cluster_size")
    public int getClusterSize() {
        return this.clusterSize;
    }
}
