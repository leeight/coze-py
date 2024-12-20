package com.coze.model.bot;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Bot extends CozeModel {
    private final String id;
    private final String name;
    private final String description;
    private final BotMode mode;
    private final BotModelInfo modelInfo;
    private final BotPromptInfo promptInfo;
    private final BotOnboardingInfo onboardingInfo;
    private final List<BotPluginInfo> plugins;

    private Bot(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.mode = builder.mode;
        this.modelInfo = builder.modelInfo;
        this.promptInfo = builder.promptInfo;
        this.onboardingInfo = builder.onboardingInfo;
        this.plugins = builder.plugins;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BotMode getMode() {
        return mode;
    }

    @JsonProperty("model_info")
    public BotModelInfo getModelInfo() {
        return modelInfo;
    }

    @JsonProperty("prompt_info")
    public BotPromptInfo getPromptInfo() {
        return promptInfo;
    }

    @JsonProperty("onboarding_info")
    public BotOnboardingInfo getOnboardingInfo() {
        return onboardingInfo;
    }

    public List<BotPluginInfo> getPlugins() {
        return plugins;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private BotMode mode;
        private BotModelInfo modelInfo;
        private BotPromptInfo promptInfo;
        private BotOnboardingInfo onboardingInfo;
        private List<BotPluginInfo> plugins;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder mode(BotMode mode) {
            this.mode = mode;
            return this;
        }

        @JsonProperty("model_info")
        public Builder modelInfo(BotModelInfo modelInfo) {
            this.modelInfo = modelInfo;
            return this;
        }

        @JsonProperty("prompt_info")
        public Builder promptInfo(BotPromptInfo promptInfo) {
            this.promptInfo = promptInfo;
            return this;
        }

        @JsonProperty("onboarding_info")
        public Builder onboardingInfo(BotOnboardingInfo onboardingInfo) {
            this.onboardingInfo = onboardingInfo;
            return this;
        }

        public Builder plugins(List<BotPluginInfo> plugins) {
            this.plugins = plugins;
            return this;
        }

        public Bot build() {
            return new Bot(this);
        }
    }
}
