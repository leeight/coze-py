package com.coze.model.document;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentFormatType {
    TEXT("text"),
    HTML("html"),
    PDF("pdf"),
    MARKDOWN("markdown"),
    DOC("doc"),
    DOCX("docx");

    private final String value;

    DocumentFormatType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
