package com.coze.model.document;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentUpdateRule extends CozeModel {
    private final String cronExpression;
    private final String webhookUrl;

    private DocumentUpdateRule(Builder builder) {
        this.cronExpression = builder.cronExpression;
        this.webhookUrl = builder.webhookUrl;
    }

    @JsonProperty("cron_expression")
    public String getCronExpression() {
        return cronExpression;
    }

    @JsonProperty("webhook_url")
    public String getWebhookUrl() {
        return webhookUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String cronExpression;
        private String webhookUrl;

        @JsonProperty("cron_expression")
        public Builder cronExpression(String cronExpression) {
            this.cronExpression = cronExpression;
            return this;
        }

        @JsonProperty("webhook_url")
        public Builder webhookUrl(String webhookUrl) {
            this.webhookUrl = webhookUrl;
            return this;
        }

        public DocumentUpdateRule build() {
            return new DocumentUpdateRule(this);
        }
    }
}
