package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.http.HttpMediaType;

public class AudioFormat {
    public static final AudioFormat BASIC;
    public static final AudioFormat FLAC;
    public static final AudioFormat OGG;
    public static final AudioFormat OGG_VORBIS;
    @Deprecated
    public static final AudioFormat PCM;
    public static final AudioFormat WAV;
    private String mediaType;

    static {
        FLAC = new AudioFormat("audio/flac");
        OGG = new AudioFormat("audio/ogg; codecs=opus");
        OGG_VORBIS = new AudioFormat("audio/ogg; codecs=vorbis");
        WAV = new AudioFormat("audio/wav");
        PCM = new AudioFormat("audio/l16");
        BASIC = new AudioFormat("audio/basic");
    }

    public static AudioFormat getPCM(int rate) {
        return new AudioFormat(HttpMediaType.createAudioRaw(rate));
    }

    public AudioFormat(String mediaType) {
        this.mediaType = mediaType;
    }

    public String toString() {
        return this.mediaType;
    }
}
