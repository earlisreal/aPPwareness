package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.util.BooleanToStringTypeAdapter;
import java.util.Date;

public class PublicationDate extends AlchemyLanguageGenericModel {
    @JsonAdapter(BooleanToStringTypeAdapter.class)
    private Boolean confident;
    private Date date;

    public PublicationDate() {
        this.confident = Boolean.valueOf(true);
    }

    public Boolean getConfident() {
        return this.confident;
    }

    public Date getDate() {
        return this.date;
    }

    public void setConfident(Boolean confident) {
        this.confident = confident;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
