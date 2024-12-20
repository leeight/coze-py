package com.coze.model.bot;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BotPluginInfo extends CozeModel {
    private final String id;
    private final String name;
    private final String description;
    private final List<BotPluginAPIInfo> apis;

    private BotPluginInfo(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.apis = builder.apis;
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

    public List<BotPluginAPIInfo> getApis() {
        return apis;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private List<BotPluginAPIInfo> apis;

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

        public Builder apis(List<BotPluginAPIInfo> apis) {
            this.apis = apis;
            return this;
        }

        public BotPluginInfo build() {
            return new BotPluginInfo(this);
        }
    }
}
