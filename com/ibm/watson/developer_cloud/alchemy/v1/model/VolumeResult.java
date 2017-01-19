package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;

public class VolumeResult extends AlchemyGenericModel {
    @SerializedName("result")
    private Volume volume;

    public Volume getVolume() {
        return this.volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }
}
