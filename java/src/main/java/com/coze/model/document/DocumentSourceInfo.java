package com.coze.model.document;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentSourceInfo extends CozeModel {
    private final String url;
    private final String text;
    private final String filePath;
    private final String fileContent;

    private DocumentSourceInfo(Builder builder) {
        this.url = builder.url;
        this.text = builder.text;
        this.filePath = builder.filePath;
        this.fileContent = builder.fileContent;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    @JsonProperty("file_path")
    public String getFilePath() {
        return filePath;
    }

    @JsonProperty("file_content")
    public String getFileContent() {
        return fileContent;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String url;
        private String text;
        private String filePath;
        private String fileContent;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        @JsonProperty("file_path")
        public Builder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        @JsonProperty("file_content")
        public Builder fileContent(String fileContent) {
            this.fileContent = fileContent;
            return this;
        }

        public DocumentSourceInfo build() {
            return new DocumentSourceInfo(this);
        }
    }
}
