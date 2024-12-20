package com.coze.model.workspace;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkspaceRoleType {
    OWNER("owner"),
    ADMIN("admin"),
    MEMBER("member"),
    GUEST("guest");

    private final String value;

    WorkspaceRoleType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
