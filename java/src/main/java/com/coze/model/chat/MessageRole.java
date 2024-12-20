package com.coze.model.chat;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageRole {
    USER("user"),
    ASSISTANT("assistant"),
    SYSTEM("system");

    private final String value;

    MessageRole(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
