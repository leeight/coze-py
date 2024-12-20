package com.coze.auth;

/**
 * Simple token-based authentication.
 */
public class TokenAuth implements Auth {
    private final String token;

    private TokenAuth(Builder builder) {
        this.token = builder.token;
    }

    @Override
    public String getToken() {
        return token;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public TokenAuth build() {
            return new TokenAuth(this);
        }
    }
}
