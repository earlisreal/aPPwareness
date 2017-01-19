package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class SolrClusterStats extends GenericModel {
    @SerializedName("disk_usage")
    private final DiskUsageStats diskUsage;
    @SerializedName("memory_usage")
    private final MemoryUsageStats memoryUsage;

    public SolrClusterStats(DiskUsageStats diskUsage, MemoryUsageStats memoryUsage) {
        this.diskUsage = diskUsage;
        this.memoryUsage = memoryUsage;
    }

    public DiskUsageStats getDiskUsage() {
        return this.diskUsage;
    }

    public MemoryUsageStats getMemoryUsage() {
        return this.memoryUsage;
    }
}
