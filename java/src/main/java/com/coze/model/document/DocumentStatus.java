package com.coze.model.document;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentStatus {
    PENDING("pending"),
    PROCESSING("processing"),
    COMPLETED("completed"),
    FAILED("failed");

    private final String value;

    DocumentStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
