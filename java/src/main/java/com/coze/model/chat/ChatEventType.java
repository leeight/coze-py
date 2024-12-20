package com.coze.model.chat;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatEventType {
    START("start"),
    MESSAGE_DELTA("message_delta"),
    COMPLETED("completed");

    private final String value;

    ChatEventType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
