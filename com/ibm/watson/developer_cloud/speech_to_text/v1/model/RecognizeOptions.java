package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;

public class RecognizeOptions {
    @SerializedName("content-type")
    private String contentType;
    private Boolean continuous;
    @SerializedName("customization_id")
    private String customizationId;
    private Integer inactivityTimeout;
    @SerializedName("interim_results")
    private Boolean interimResults;
    private String[] keywords;
    @SerializedName("keywords_threshold")
    private Double keywordsThreshold;
    private Integer maxAlternatives;
    private String model;
    private Boolean profanityFilter;
    private String sessionId;
    @SerializedName("smart_formatting")
    private Boolean smartFormatting;
    @SerializedName("diarization")
    private Boolean speakerLabels;
    private Boolean timestamps;
    @SerializedName("word_alternatives_threshold")
    private Double wordAlternativesThreshold;
    @SerializedName("word_confidence")
    private Boolean wordConfidence;

    private RecognizeOptions(Builder builder) {
        this.contentType = Builder.access$1700(builder);
        this.continuous = Builder.access$1800(builder);
        this.inactivityTimeout = Builder.access$1900(builder);
        this.interimResults = Builder.access$2000(builder);
        this.keywords = Builder.access$2100(builder);
        this.keywordsThreshold = Builder.access$2200(builder);
        this.maxAlternatives = Builder.access$2300(builder);
        this.model = Builder.access$2400(builder);
        this.sessionId = Builder.access$2500(builder);
        this.timestamps = Builder.access$2600(builder);
        this.wordAlternativesThreshold = Builder.access$2700(builder);
        this.wordConfidence = Builder.access$2800(builder);
        this.profanityFilter = Builder.access$2900(builder);
        this.smartFormatting = Builder.access$3000(builder);
        this.customizationId = Builder.access$3100(builder);
        this.speakerLabels = Builder.access$3200(builder);
    }

    public String customizationId() {
        return this.customizationId;
    }

    public String contentType() {
        return this.contentType;
    }

    public Boolean profanityFilter() {
        return this.profanityFilter;
    }

    public Boolean smartFormatting() {
        return this.smartFormatting;
    }

    public Boolean speakerLabels() {
        return this.speakerLabels;
    }

    public Boolean continuous() {
        return this.continuous;
    }

    public Integer inactivityTimeout() {
        return this.inactivityTimeout;
    }

    public Boolean interimResults() {
        return this.interimResults;
    }

    public String[] keywords() {
        return this.keywords == null ? null : (String[]) this.keywords.clone();
    }

    public Double keywordsThreshold() {
        return this.keywordsThreshold;
    }

    public Integer maxAlternatives() {
        return this.maxAlternatives;
    }

    public String model() {
        return this.model;
    }

    public Builder newBuilder() {
        return new Builder(this, null);
    }

    public String sessionId() {
        return this.sessionId;
    }

    public Boolean timestamps() {
        return this.timestamps;
    }

    public Double wordAlternativesThreshold() {
        return this.wordAlternativesThreshold;
    }

    public Boolean wordConfidence() {
        return this.wordConfidence;
    }
}
