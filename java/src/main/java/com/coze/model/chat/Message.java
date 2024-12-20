package com.coze.model.chat;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message extends CozeModel {
    private final String content;
    private final MessageRole role;

    private Message(Builder builder) {
        this.content = builder.content;
        this.role = builder.role;
    }

    public String getContent() {
        return content;
    }

    public MessageRole getRole() {
        return role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String content;
        private MessageRole role;

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder role(MessageRole role) {
            this.role = role;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
