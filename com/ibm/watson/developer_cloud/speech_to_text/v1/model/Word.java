package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Arrays;
import java.util.List;

public class Word extends GenericModel {
    @SerializedName("display_as")
    private String displayAs;
    @SerializedName("sounds_like")
    private List<String> soundsLike;
    private String word;

    public Word(String word, String displayAs, String... soundsLike) {
        this();
        this.word = word;
        this.displayAs = displayAs;
        this.soundsLike = Arrays.asList(soundsLike);
    }

    public String getDisplayAs() {
        return this.displayAs;
    }

    public List<String> getSoundsLike() {
        return this.soundsLike;
    }

    public String getWord() {
        return this.word;
    }

    public void setDisplayAs(String displayAs) {
        this.displayAs = displayAs;
    }

    public void setSoundsLike(List<String> soundsLike) {
        this.soundsLike = soundsLike;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
