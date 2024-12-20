package com.coze.model.workflow;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkflowRunMode {
    SYNC("sync"),
    ASYNC("async");

    private final String value;

    WorkflowRunMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
