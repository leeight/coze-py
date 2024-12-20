package com.coze.client.service;

import com.coze.model.workspace.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AsyncWorkspaceClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/workspaces";

    public AsyncWorkspaceClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CompletableFuture<List<Workspace>> listWorkspaces() {
        return httpClient.getAsync(BASE_PATH, new TypeReference<List<Workspace>>() {});
    }

    public CompletableFuture<Workspace> getWorkspace(String workspaceId) {
        return httpClient.getAsync(BASE_PATH + "/" + workspaceId, Workspace.class);
    }

    public CompletableFuture<Workspace> createWorkspace(Workspace workspace) {
        return httpClient.postAsync(BASE_PATH, workspace, Workspace.class);
    }

    public CompletableFuture<Workspace> updateWorkspace(String workspaceId, Workspace workspace) {
        return httpClient.putAsync(BASE_PATH + "/" + workspaceId, workspace, Workspace.class);
    }

    public CompletableFuture<Void> deleteWorkspace(String workspaceId) {
        return httpClient.deleteAsync(BASE_PATH + "/" + workspaceId);
    }
}
