package com.coze.model.chat;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatEvent extends CozeModel {
    private final ChatEventType type;
    private final String content;
    private final String requestId;

    private ChatEvent(Builder builder) {
        this.type = builder.type;
        this.content = builder.content;
        this.requestId = builder.requestId;
    }

    public ChatEventType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    @JsonProperty("request_id")
    public String getRequestId() {
        return requestId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ChatEventType type;
        private String content;
        private String requestId;

        public Builder type(ChatEventType type) {
            this.type = type;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        @JsonProperty("request_id")
        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public ChatEvent build() {
            return new ChatEvent(this);
        }
    }
}
