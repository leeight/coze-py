package com.coze.model.bot;


import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotOnboardingInfo extends CozeModel {
    private final String welcomeMessage;
    private final String suggestedPrompt;

    private BotOnboardingInfo(Builder builder) {
        this.welcomeMessage = builder.welcomeMessage;
        this.suggestedPrompt = builder.suggestedPrompt;
    }

    @JsonProperty("welcome_message")
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @JsonProperty("suggested_prompt")
    public String getSuggestedPrompt() {
        return suggestedPrompt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String welcomeMessage;
        private String suggestedPrompt;

        @JsonProperty("welcome_message")
        public Builder welcomeMessage(String welcomeMessage) {
            this.welcomeMessage = welcomeMessage;
            return this;
        }

        @JsonProperty("suggested_prompt")
        public Builder suggestedPrompt(String suggestedPrompt) {
            this.suggestedPrompt = suggestedPrompt;
            return this;
        }

        public BotOnboardingInfo build() {
            return new BotOnboardingInfo(this);
        }
    }
}
