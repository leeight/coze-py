package com.coze.client;

import com.coze.client.service.*;
import com.coze.request.CozeHttpClient;

public class Coze {
    private final CozeHttpClient httpClient;
    private final ChatClient chatClient;
    private final BotClient botClient;
    private final WorkflowClient workflowClient;
    private final AudioClient audioClient;
    private final WorkspaceClient workspaceClient;

    private Coze(Builder builder) {
        this.httpClient = new CozeHttpClient(builder.token);
        this.chatClient = new ChatClient(httpClient);
        this.botClient = new BotClient(httpClient);
        this.workflowClient = new WorkflowClient(httpClient);
        this.audioClient = new AudioClient(httpClient);
        this.workspaceClient = new WorkspaceClient(httpClient);
    }

    public ChatClient chat() {
        return chatClient;
    }

    public BotClient bot() {
        return botClient;
    }

    public WorkflowClient workflow() {
        return workflowClient;
    }

    public AudioClient audio() {
        return audioClient;
    }

    public WorkspaceClient workspace() {
        return workspaceClient;
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

        public Coze build() {
            return new Coze(this);
        }
    }
}
