package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class DiskUsageStats extends GenericModel {
    @SerializedName("percent_used")
    private final double percentUsed;
    @SerializedName("total")
    private final String total;
    @SerializedName("total_bytes")
    private final long totalBytes;
    @SerializedName("used")
    private final String used;
    @SerializedName("used_bytes")
    private final long usedBytes;

    public DiskUsageStats(long usedBytes, long totalBytes, String used, String total, double percentUsed) {
        this.usedBytes = usedBytes;
        this.totalBytes = totalBytes;
        this.used = used;
        this.total = total;
        this.percentUsed = percentUsed;
    }

    public String getUsed() {
        return this.used;
    }

    public long getUsedBytes() {
        return this.usedBytes;
    }

    public String getTotal() {
        return this.total;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public double getPercentUsed() {
        return this.percentUsed;
    }
}
