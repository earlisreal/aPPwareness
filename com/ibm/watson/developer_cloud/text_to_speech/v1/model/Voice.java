package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Voice extends GenericModel {
    public static final List<Voice> ALL;
    public static final Voice DE_BIRGIT;
    public static final Voice DE_DIETER;
    @Deprecated
    public static final Voice DE_GIRGIT;
    public static final Voice EN_ALLISON;
    public static final Voice EN_LISA;
    public static final Voice EN_MICHAEL;
    public static final Voice ES_ENRIQUE;
    public static final Voice ES_LAURA;
    public static final Voice ES_SOFIA;
    private static final String FEMALE = "female";
    public static final Voice FR_RENEE;
    public static final Voice GB_KATE;
    public static final Voice IT_FRANCESCA;
    public static final Voice JA_EMI;
    public static final Voice LA_SOFIA;
    private static final String MALE = "male";
    public static final Voice PT_ISABELA;
    private String description;
    private String gender;
    private String language;
    private String name;
    @SerializedName("supported_features")
    private SupportedFeatures supportedFeatures;
    private String url;

    public class SupportedFeatures {
        @SerializedName("custom_pronunciation")
        private Boolean customPronunciation;
        @SerializedName("voice_transformation")
        private Boolean voiceTransformation;

        public Boolean getCustomPronunciation() {
            return this.customPronunciation;
        }

        public Boolean getVoiceTransformation() {
            return this.voiceTransformation;
        }

        public void setCustomPronunciation(Boolean customPronunciation) {
            this.customPronunciation = customPronunciation;
        }

        public void setVoiceTransformation(Boolean voiceTransformation) {
            this.voiceTransformation = voiceTransformation;
        }
    }

    static {
        DE_BIRGIT = new Voice("de-DE_BirgitVoice", FEMALE, "de-DE");
        DE_DIETER = new Voice("de-DE_DieterVoice", MALE, "de-DE");
        DE_GIRGIT = DE_BIRGIT;
        EN_ALLISON = new Voice("en-US_AllisonVoice", FEMALE, "en-US");
        EN_LISA = new Voice("en-US_LisaVoice", FEMALE, "en-US");
        EN_MICHAEL = new Voice("en-US_MichaelVoice", MALE, "en-US");
        ES_ENRIQUE = new Voice("es-ES_EnriqueVoice", MALE, "es-ES");
        ES_LAURA = new Voice("es-ES_LauraVoice", FEMALE, "es-US");
        ES_SOFIA = new Voice("es-US_SofiaVoice", FEMALE, "es-US");
        FR_RENEE = new Voice("fr-FR_ReneeVoice", FEMALE, "fr-FR");
        GB_KATE = new Voice("en-GB_KateVoice", FEMALE, "en-GB");
        IT_FRANCESCA = new Voice("it-IT_FrancescaVoice", FEMALE, "it-IT");
        JA_EMI = new Voice("ja-JP_EmiVoice", FEMALE, "ja-JP");
        LA_SOFIA = new Voice("es-LA_SofiaVoice", FEMALE, "es-LA");
        PT_ISABELA = new Voice("pt-BR_IsabelaVoice", FEMALE, "pt-BR");
        ALL = Collections.unmodifiableList(Arrays.asList(new Voice[]{DE_DIETER, DE_BIRGIT, EN_ALLISON, EN_LISA, EN_MICHAEL, ES_ENRIQUE, ES_LAURA, ES_SOFIA, LA_SOFIA, FR_RENEE, GB_KATE, IT_FRANCESCA, JA_EMI, PT_ISABELA}));
    }

    public static Voice getByName(String name) {
        for (Voice voice : ALL) {
            if (voice.getName().equals(name)) {
                return voice;
            }
        }
        return null;
    }

    public Voice(String name, String gender, String language) {
        this.name = name;
        this.gender = gender;
        this.language = language;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGender() {
        return this.gender;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getName() {
        return this.name;
    }

    public SupportedFeatures getSupportedFeatures() {
        return this.supportedFeatures;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSupportedFeatures(SupportedFeatures supportedFeatures) {
        this.supportedFeatures = supportedFeatures;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
