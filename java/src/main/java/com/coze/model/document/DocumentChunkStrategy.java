package com.coze.model.document;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentChunkStrategy {
    FIXED_SIZE("fixed_size"),
    PARAGRAPH("paragraph"),
    SENTENCE("sentence");

    private final String value;

    DocumentChunkStrategy(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
