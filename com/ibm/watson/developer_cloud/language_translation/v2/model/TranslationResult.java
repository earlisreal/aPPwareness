package com.ibm.watson.developer_cloud.language_translation.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class TranslationResult extends GenericModel {
    @SerializedName("character_count")
    private Integer characterCount;
    private List<Translation> translations;
    @SerializedName("word_count")
    private Integer wordCount;

    public Integer getCharacterCount() {
        return this.characterCount;
    }

    public String getFirstTranslation() {
        if (this.translations == null || this.translations.isEmpty()) {
            return null;
        }
        return ((Translation) this.translations.get(0)).getTranslation();
    }

    public List<Translation> getTranslations() {
        return this.translations;
    }

    public Integer getWordCount() {
        return this.wordCount;
    }

    public void setCharacterCount(Integer characterCount) {
        this.characterCount = characterCount;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }
}
