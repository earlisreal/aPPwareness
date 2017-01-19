package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class SolrConfigs extends GenericModel {
    @SerializedName("solr_configs")
    private final List<String> solrConfigs;

    public SolrConfigs(List<String> solrConfigs) {
        this.solrConfigs = solrConfigs;
    }

    public List<String> getSolrConfigs() {
        return this.solrConfigs;
    }
}
