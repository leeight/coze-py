package com.coze.client.service;

import com.coze.model.workspace.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class WorkspaceClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/workspaces";

    public WorkspaceClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<Workspace> listWorkspaces() {
        return httpClient.get(BASE_PATH, new TypeReference<List<Workspace>>() {});
    }

    public Workspace getWorkspace(String workspaceId) {
        return httpClient.get(BASE_PATH + "/" + workspaceId, Workspace.class);
    }

    public Workspace createWorkspace(Workspace workspace) {
        return httpClient.post(BASE_PATH, workspace, Workspace.class);
    }

    public Workspace updateWorkspace(String workspaceId, Workspace workspace) {
        return httpClient.put(BASE_PATH + "/" + workspaceId, workspace, Workspace.class);
    }

    public void deleteWorkspace(String workspaceId) {
        httpClient.delete(BASE_PATH + "/" + workspaceId);
    }
}
