package com.coze.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document extends DocumentBase {
    private final DocumentStatus status;
    private final String error;
    private final long createdAt;
    private final long updatedAt;

    private Document(Builder builder) {
        super(builder);
        this.status = builder.status;
        this.error = builder.error;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    @JsonProperty("created_at")
    public long getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("updated_at")
    public long getUpdatedAt() {
        return updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends DocumentBase.Builder<Builder> {
        private DocumentStatus status;
        private String error;
        private long createdAt;
        private long updatedAt;

        @Override
        protected Builder self() {
            return this;
        }

        public Builder status(DocumentStatus status) {
            this.status = status;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        @JsonProperty("created_at")
        public Builder createdAt(long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @JsonProperty("updated_at")
        public Builder updatedAt(long updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @Override
        public Document build() {
            return new Document(this);
        }
    }
}
