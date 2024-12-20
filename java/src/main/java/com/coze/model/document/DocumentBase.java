package com.coze.model.document;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentBase extends CozeModel {
    private final String id;
    private final String name;
    private final String description;
    private final DocumentSourceType sourceType;
    private final DocumentSourceInfo sourceInfo;
    private final DocumentFormatType format;
    private final DocumentChunkStrategy chunkStrategy;
    private final DocumentUpdateType updateType;
    private final DocumentUpdateRule updateRule;

    protected DocumentBase(Builder<?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.sourceType = builder.sourceType;
        this.sourceInfo = builder.sourceInfo;
        this.format = builder.format;
        this.chunkStrategy = builder.chunkStrategy;
        this.updateType = builder.updateType;
        this.updateRule = builder.updateRule;
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

    @JsonProperty("source_type")
    public DocumentSourceType getSourceType() {
        return sourceType;
    }

    @JsonProperty("source_info")
    public DocumentSourceInfo getSourceInfo() {
        return sourceInfo;
    }

    public DocumentFormatType getFormat() {
        return format;
    }

    @JsonProperty("chunk_strategy")
    public DocumentChunkStrategy getChunkStrategy() {
        return chunkStrategy;
    }

    @JsonProperty("update_type")
    public DocumentUpdateType getUpdateType() {
        return updateType;
    }

    @JsonProperty("update_rule")
    public DocumentUpdateRule getUpdateRule() {
        return updateRule;
    }

    public abstract static class Builder<T extends Builder<T>> {
        private String id;
        private String name;
        private String description;
        private DocumentSourceType sourceType;
        private DocumentSourceInfo sourceInfo;
        private DocumentFormatType format;
        private DocumentChunkStrategy chunkStrategy;
        private DocumentUpdateType updateType;
        private DocumentUpdateRule updateRule;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T id(String id) {
            this.id = id;
            return self();
        }

        public T name(String name) {
            this.name = name;
            return self();
        }

        public T description(String description) {
            this.description = description;
            return self();
        }

        @JsonProperty("source_type")
        public T sourceType(DocumentSourceType sourceType) {
            this.sourceType = sourceType;
            return self();
        }

        @JsonProperty("source_info")
        public T sourceInfo(DocumentSourceInfo sourceInfo) {
            this.sourceInfo = sourceInfo;
            return self();
        }

        public T format(DocumentFormatType format) {
            this.format = format;
            return self();
        }

        @JsonProperty("chunk_strategy")
        public T chunkStrategy(DocumentChunkStrategy chunkStrategy) {
            this.chunkStrategy = chunkStrategy;
            return self();
        }

        @JsonProperty("update_type")
        public T updateType(DocumentUpdateType updateType) {
            this.updateType = updateType;
            return self();
        }

        @JsonProperty("update_rule")
        public T updateRule(DocumentUpdateRule updateRule) {
            this.updateRule = updateRule;
            return self();
        }

        public abstract DocumentBase build();
    }
}
