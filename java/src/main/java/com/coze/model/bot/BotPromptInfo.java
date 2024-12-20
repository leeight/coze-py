package com.coze.model.bot;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BotPromptInfo extends CozeModel {
    private final String prompt;
    private final List<String> examples;
    private final List<String> knowledgeSources;

    private BotPromptInfo(Builder builder) {
        this.prompt = builder.prompt;
        this.examples = builder.examples;
        this.knowledgeSources = builder.knowledgeSources;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getExamples() {
        return examples;
    }

    @JsonProperty("knowledge_sources")
    public List<String> getKnowledgeSources() {
        return knowledgeSources;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String prompt;
        private List<String> examples;
        private List<String> knowledgeSources;

        public Builder prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        public Builder examples(List<String> examples) {
            this.examples = examples;
            return this;
        }

        @JsonProperty("knowledge_sources")
        public Builder knowledgeSources(List<String> knowledgeSources) {
            this.knowledgeSources = knowledgeSources;
            return this;
        }

        public BotPromptInfo build() {
            return new BotPromptInfo(this);
        }
    }
}
