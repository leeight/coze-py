package com.coze.model.bot;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotPluginAPIInfo extends CozeModel {
    private final String name;
    private final String description;
    private final String endpoint;
    private final String method;
    private final String schema;

    private BotPluginAPIInfo(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.endpoint = builder.endpoint;
        this.method = builder.method;
        this.schema = builder.schema;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getMethod() {
        return method;
    }

    public String getSchema() {
        return schema;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;
        private String endpoint;
        private String method;
        private String schema;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder schema(String schema) {
            this.schema = schema;
            return this;
        }

        public BotPluginAPIInfo build() {
            return new BotPluginAPIInfo(this);
        }
    }
}
