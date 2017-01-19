package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class ConsumptionPreferences extends GenericModel {
    @SerializedName("consumption_preference_category_id")
    private String categoryId;
    @SerializedName("consumption_preferences")
    private List<ConsumptionPreference> consumptionPreferences;
    private String name;

    public class ConsumptionPreference extends GenericModel {
        @SerializedName("consumption_preference_id")
        private String id;
        private String name;
        private Double score;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getScore() {
            return this.score;
        }

        public void setScore(Double score) {
            this.score = score;
        }
    }

    public List<ConsumptionPreference> getConsumptionPreferences() {
        return this.consumptionPreferences;
    }

    public void setConsumptionPreferences(List<ConsumptionPreference> consumptionPreferences) {
        this.consumptionPreferences = consumptionPreferences;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
