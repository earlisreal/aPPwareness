package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;

public class Language extends AlchemyLanguageGenericModel {
    private String ethnologue;
    @SerializedName("iso-639-1")
    private String iso6391;
    @SerializedName("iso-639-2")
    private String iso6392;
    @SerializedName("iso-639-3")
    private String iso6393;
    @SerializedName("native-speakers")
    private String nativeSpeakers;
    private String wikipedia;

    public String getEthnologue() {
        return this.ethnologue;
    }

    public String getIso6391() {
        return this.iso6391;
    }

    public String getIso6392() {
        return this.iso6392;
    }

    public String getIso6393() {
        return this.iso6393;
    }

    public String getNativeSpeakers() {
        return this.nativeSpeakers;
    }

    public String getWikipedia() {
        return this.wikipedia;
    }

    public void setEthnologue(String ethnologue) {
        this.ethnologue = ethnologue;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public void setIso6392(String iso6392) {
        this.iso6392 = iso6392;
    }

    public void setIso6393(String iso6393) {
        this.iso6393 = iso6393;
    }

    public void setNativeSpeakers(String nativeSpeakers) {
        this.nativeSpeakers = nativeSpeakers;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }
}
