package com.coze.model.document;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentUpdateType {
    MANUAL("manual"),
    AUTO("auto");

    private final String value;

    DocumentUpdateType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
