package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.util.Validator;

public class SolrClusterOptions {
    private static final String FREE_CLUSTER_SIZE = "";
    @SerializedName("cluster_name")
    private final String clusterName;
    @SerializedName("cluster_size")
    private final String clusterSize;

    public SolrClusterOptions(String clusterName, Integer clusterSize) {
        this.clusterName = clusterName;
        if (clusterSize == null) {
            this.clusterSize = FREE_CLUSTER_SIZE;
            return;
        }
        Validator.isTrue(clusterSize.intValue() > 0, "clusterSize cannot be lower than 0");
        this.clusterSize = clusterSize.toString();
    }

    public SolrClusterOptions(String clusterName) {
        this.clusterName = clusterName;
        this.clusterSize = FREE_CLUSTER_SIZE;
    }

    public String clusterName() {
        return this.clusterName;
    }

    public Integer clusterSize() {
        if (FREE_CLUSTER_SIZE.equals(this.clusterSize)) {
            return null;
        }
        return Integer.valueOf(this.clusterSize);
    }
}
