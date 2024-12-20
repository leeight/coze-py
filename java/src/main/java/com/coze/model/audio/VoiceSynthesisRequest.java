package com.coze.model.audio;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VoiceSynthesisRequest extends CozeModel {
    private final String text;
    private final String voiceId;
    private final AudioFormat format;
    private final double speed;
    private final double pitch;

    private VoiceSynthesisRequest(Builder builder) {
        this.text = builder.text;
        this.voiceId = builder.voiceId;
        this.format = builder.format;
        this.speed = builder.speed;
        this.pitch = builder.pitch;
    }

    public String getText() {
        return text;
    }

    @JsonProperty("voice_id")
    public String getVoiceId() {
        return voiceId;
    }

    public AudioFormat getFormat() {
        return format;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPitch() {
        return pitch;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String text;
        private String voiceId;
        private AudioFormat format;
        private double speed;
        private double pitch;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        @JsonProperty("voice_id")
        public Builder voiceId(String voiceId) {
            this.voiceId = voiceId;
            return this;
        }

        public Builder format(AudioFormat format) {
            this.format = format;
            return this;
        }

        public Builder speed(double speed) {
            this.speed = speed;
            return this;
        }

        public Builder pitch(double pitch) {
            this.pitch = pitch;
            return this;
        }

        public VoiceSynthesisRequest build() {
            return new VoiceSynthesisRequest(this);
        }
    }
}
