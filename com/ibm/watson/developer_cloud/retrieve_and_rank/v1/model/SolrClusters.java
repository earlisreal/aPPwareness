package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class SolrClusters extends GenericModel {
    @SerializedName("clusters")
    private final List<SolrCluster> solrClusters;

    public SolrClusters(List<SolrCluster> solrClusterResponses) {
        this.solrClusters = solrClusterResponses;
    }

    public List<SolrCluster> getSolrClusters() {
        return this.solrClusters;
    }
}
