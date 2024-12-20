package com.coze.model.workflow;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkflowRunStatus {
    PENDING("pending"),
    RUNNING("running"),
    COMPLETED("completed"),
    FAILED("failed"),
    CANCELLED("cancelled");

    private final String value;

    WorkflowRunStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
