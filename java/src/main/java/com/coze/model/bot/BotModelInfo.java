package com.coze.model.bot;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotModelInfo extends CozeModel {
    private final String name;
    private final String version;
    private final int maxTokens;
    private final double temperature;
    private final double topP;
    private final double presencePenalty;
    private final double frequencyPenalty;

    private BotModelInfo(Builder builder) {
        this.name = builder.name;
        this.version = builder.version;
        this.maxTokens = builder.maxTokens;
        this.temperature = builder.temperature;
        this.topP = builder.topP;
        this.presencePenalty = builder.presencePenalty;
        this.frequencyPenalty = builder.frequencyPenalty;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    @JsonProperty("max_tokens")
    public int getMaxTokens() {
        return maxTokens;
    }

    public double getTemperature() {
        return temperature;
    }

    @JsonProperty("top_p")
    public double getTopP() {
        return topP;
    }

    @JsonProperty("presence_penalty")
    public double getPresencePenalty() {
        return presencePenalty;
    }

    @JsonProperty("frequency_penalty")
    public double getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String version;
        private int maxTokens;
        private double temperature;
        private double topP;
        private double presencePenalty;
        private double frequencyPenalty;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        @JsonProperty("max_tokens")
        public Builder maxTokens(int maxTokens) {
            this.maxTokens = maxTokens;
            return this;
        }

        public Builder temperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        @JsonProperty("top_p")
        public Builder topP(double topP) {
            this.topP = topP;
            return this;
        }

        @JsonProperty("presence_penalty")
        public Builder presencePenalty(double presencePenalty) {
            this.presencePenalty = presencePenalty;
            return this;
        }

        @JsonProperty("frequency_penalty")
        public Builder frequencyPenalty(double frequencyPenalty) {
            this.frequencyPenalty = frequencyPenalty;
            return this;
        }

        public BotModelInfo build() {
            return new BotModelInfo(this);
        }
    }
}
