package com.coze.model.audio;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AudioFormat {
    MP3("mp3"),
    WAV("wav"),
    OGG("ogg"),
    AAC("aac");

    private final String value;

    AudioFormat(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
