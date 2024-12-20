package com.coze.model.audio;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AudioResponse extends CozeModel {
    private final String audioData;
    private final AudioFormat format;
    private final long duration;
    private final long size;

    private AudioResponse(Builder builder) {
        this.audioData = builder.audioData;
        this.format = builder.format;
        this.duration = builder.duration;
        this.size = builder.size;
    }

    @JsonProperty("audio_data")
    public String getAudioData() {
        return audioData;
    }

    public AudioFormat getFormat() {
        return format;
    }

    public long getDuration() {
        return duration;
    }

    public long getSize() {
        return size;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String audioData;
        private AudioFormat format;
        private long duration;
        private long size;

        @JsonProperty("audio_data")
        public Builder audioData(String audioData) {
            this.audioData = audioData;
            return this;
        }

        public Builder format(AudioFormat format) {
            this.format = format;
            return this;
        }

        public Builder duration(long duration) {
            this.duration = duration;
            return this;
        }

        public Builder size(long size) {
            this.size = size;
            return this;
        }

        public AudioResponse build() {
            return new AudioResponse(this);
        }
    }
}
