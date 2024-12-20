package com.coze.model.audio;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Voice extends CozeModel {
    private final String id;
    private final String name;
    private final String description;
    private final String language;
    private final String gender;
    private final String accent;
    private final String style;
    private final double speed;
    private final double pitch;

    private Voice(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.language = builder.language;
        this.gender = builder.gender;
        this.accent = builder.accent;
        this.style = builder.style;
        this.speed = builder.speed;
        this.pitch = builder.pitch;
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

    public String getLanguage() {
        return language;
    }

    public String getGender() {
        return gender;
    }

    public String getAccent() {
        return accent;
    }

    public String getStyle() {
        return style;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPitch() {
        return pitch;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private String language;
        private String gender;
        private String accent;
        private String style;
        private double speed;
        private double pitch;

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

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder accent(String accent) {
            this.accent = accent;
            return this;
        }

        public Builder style(String style) {
            this.style = style;
            return this;
        }

        public Builder speed(double speed) {
            this.speed = speed;
            return this;
        }

        public Builder pitch(double pitch) {
            this.pitch = pitch;
            return this;
        }

        public Voice build() {
            return new Voice(this);
        }
    }
}
