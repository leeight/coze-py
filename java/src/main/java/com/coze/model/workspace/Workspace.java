package com.coze.model.workspace;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Workspace extends CozeModel {
    private final String id;
    private final String name;
    private final String description;
    private final WorkspaceType type;
    private final List<WorkspaceRoleType> roles;

    private Workspace(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.type = builder.type;
        this.roles = builder.roles;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public WorkspaceType getType() {
        return type;
    }

    public List<WorkspaceRoleType> getRoles() {
        return roles;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private WorkspaceType type;
        private List<WorkspaceRoleType> roles;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder type(WorkspaceType type) {
            this.type = type;
            return this;
        }

        public Builder roles(List<WorkspaceRoleType> roles) {
            this.roles = roles;
            return this;
        }

        public Workspace build() {
            return new Workspace(this);
        }
    }
}
