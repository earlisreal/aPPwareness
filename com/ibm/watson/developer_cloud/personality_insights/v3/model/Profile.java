package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Profile extends GenericModel {
    private List<Behavior> behavior;
    @SerializedName("consumption_preferences")
    private List<ConsumptionPreferences> consumptionPreferences;
    private List<Trait> needs;
    private List<Trait> personality;
    @SerializedName("processed_language")
    private String processedLanguage;
    private List<Trait> values;
    private List<Warning> warnings;
    @SerializedName("word_count")
    private Integer wordCount;
    @SerializedName("word_count_message")
    private String wordCountMessage;

    public class Warning extends GenericModel {
        @SerializedName("warning_id")
        private String id;
        private String message;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public String getWordCountMessage() {
        return this.wordCountMessage;
    }

    public List<Behavior> getBehavior() {
        return this.behavior;
    }

    public void setBehavior(List<Behavior> behavior) {
        this.behavior = behavior;
    }

    public void setWordCountMessage(String wordCountMessage) {
        this.wordCountMessage = wordCountMessage;
    }

    public Integer getWordCount() {
        return this.wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public String getProcessedLanguage() {
        return this.processedLanguage;
    }

    public void setProcessedLanguage(String processedLanguage) {
        this.processedLanguage = processedLanguage;
    }

    public List<Trait> getPersonality() {
        return this.personality;
    }

    public void setPersonality(List<Trait> personality) {
        this.personality = personality;
    }

    public List<Trait> getNeeds() {
        return this.needs;
    }

    public void setNeeds(List<Trait> needs) {
        this.needs = needs;
    }

    public List<Trait> getValues() {
        return this.values;
    }

    public void setValues(List<Trait> values) {
        this.values = values;
    }

    public List<ConsumptionPreferences> getConsumptionPreferences() {
        return this.consumptionPreferences;
    }

    public void setConsumptionPreferences(List<ConsumptionPreferences> consumptionPreferences) {
        this.consumptionPreferences = consumptionPreferences;
    }

    public List<Warning> getWarnings() {
        return this.warnings;
    }

    public void setWarnings(List<Warning> warnings) {
        this.warnings = warnings;
    }
}
