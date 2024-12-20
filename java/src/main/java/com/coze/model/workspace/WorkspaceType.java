package com.coze.model.workspace;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkspaceType {
    PERSONAL("personal"),
    TEAM("team"),
    ENTERPRISE("enterprise");

    private final String value;

    WorkspaceType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
