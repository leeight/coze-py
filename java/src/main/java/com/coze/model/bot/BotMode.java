package com.coze.model.bot;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BotMode {
    CHAT("chat"),
    COMPLETION("completion");

    private final String value;

    BotMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
