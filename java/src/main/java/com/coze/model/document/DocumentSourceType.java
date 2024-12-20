package com.coze.model.document;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentSourceType {
    FILE("file"),
    URL("url"),
    TEXT("text");

    private final String value;

    DocumentSourceType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
