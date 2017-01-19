package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.util.ColumnTypeAdapter;

@JsonAdapter(ColumnTypeAdapter.class)
public abstract class Column extends GenericModel {
    private String description;
    private String format;
    @SerializedName("full_name")
    private String fullName;
    private Goal goal;
    @SerializedName("insignificant_loss")
    private Double insignificantLoss;
    private String key;
    @SerializedName("is_objective")
    private Boolean objective;
    @SerializedName("significant_gain")
    private Double significantGain;
    @SerializedName("significant_loss")
    private Double significantLoss;
    private ColumnType type;

    public Column(ColumnType type) {
        this.type = type;
    }

    protected void setType(ColumnType type) {
        this.type = type;
    }

    public Column fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFormat() {
        return this.format;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Goal getGoal() {
        return this.goal;
    }

    public Double getInsignificantLoss() {
        return this.insignificantLoss;
    }

    public String getKey() {
        return this.key;
    }

    public Double getSignificantGain() {
        return this.significantGain;
    }

    public Double getSignificantLoss() {
        return this.significantLoss;
    }

    public ColumnType getType() {
        return this.type;
    }

    public Column goal(Goal goal) {
        this.goal = goal;
        return this;
    }

    public Boolean isObjective() {
        return this.objective;
    }

    public Column key(String key) {
        this.key = key;
        return this;
    }

    public Column objective(boolean objective) {
        this.objective = Boolean.valueOf(objective);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setInsignificantLoss(Double insignificantLoss) {
        this.insignificantLoss = insignificantLoss;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setObjective(boolean objective) {
        this.objective = Boolean.valueOf(objective);
    }

    public void setSignificantGain(Double significantGain) {
        this.significantGain = significantGain;
    }

    public void setSignificantLoss(Double significantLoss) {
        this.significantLoss = significantLoss;
    }
}
