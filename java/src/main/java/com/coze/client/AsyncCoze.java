package com.coze.client;

import com.coze.client.service.*;
import com.coze.request.CozeHttpClient;

public class AsyncCoze {
    private final CozeHttpClient httpClient;
    private final AsyncChatClient chatClient;
    private final AsyncBotClient botClient;
    private final AsyncWorkflowClient workflowClient;
    private final AsyncAudioClient audioClient;
    private final AsyncWorkspaceClient workspaceClient;

    private AsyncCoze(Builder builder) {
        this.httpClient = new CozeHttpClient(builder.token);
        this.chatClient = new AsyncChatClient(httpClient);
        this.botClient = new AsyncBotClient(httpClient);
        this.workflowClient = new AsyncWorkflowClient(httpClient);
        this.audioClient = new AsyncAudioClient(httpClient);
        this.workspaceClient = new AsyncWorkspaceClient(httpClient);
    }

    public AsyncChatClient chat() {
        return chatClient;
    }

    public AsyncBotClient bot() {
        return botClient;
    }

    public AsyncWorkflowClient workflow() {
        return workflowClient;
    }

    public AsyncAudioClient audio() {
        return audioClient;
    }

    public AsyncWorkspaceClient workspace() {
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

        public AsyncCoze build() {
            return new AsyncCoze(this);
        }
    }
}
