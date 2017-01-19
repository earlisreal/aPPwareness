package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class SolrCluster extends GenericModel {
    @SerializedName("solr_cluster_id")
    private final String solrClusterId;
    @SerializedName("cluster_name")
    private final String solrClusterName;
    @SerializedName("cluster_size")
    private final String solrClusterSize;
    @SerializedName("solr_cluster_status")
    private final Status solrClusterStatus;

    public SolrCluster(String solrClusterId, String solrClusterName, String solrClusterSize, Status solrClusterStatus) {
        this.solrClusterId = solrClusterId;
        this.solrClusterName = solrClusterName;
        this.solrClusterSize = solrClusterSize;
        this.solrClusterStatus = solrClusterStatus;
    }

    public String getId() {
        return this.solrClusterId;
    }

    public String getName() {
        return this.solrClusterName;
    }

    public String getSize() {
        return this.solrClusterSize;
    }

    public Status getStatus() {
        return this.solrClusterStatus;
    }
}
