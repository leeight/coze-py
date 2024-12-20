package com.coze.client.service;

import com.coze.model.workflow.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AsyncWorkflowClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/workflows";

    public AsyncWorkflowClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CompletableFuture<WorkflowRun> executeWorkflow(WorkflowExecuteRequest request) {
        return httpClient.postAsync(BASE_PATH + "/execute", request, WorkflowRun.class);
    }

    public CompletableFuture<WorkflowRun> getWorkflowRun(String runId) {
        return httpClient.getAsync(BASE_PATH + "/runs/" + runId, WorkflowRun.class);
    }

    public CompletableFuture<List<WorkflowRun>> listWorkflowRuns(String workflowId) {
        return httpClient.getAsync(BASE_PATH + "/" + workflowId + "/runs",
            new TypeReference<List<WorkflowRun>>() {});
    }

    public CompletableFuture<Void> cancelWorkflowRun(String runId) {
        return httpClient.postAsync(BASE_PATH + "/runs/" + runId + "/cancel", null, Void.class);
    }

    public CompletableFuture<Void> deleteWorkflowRun(String runId) {
        return httpClient.deleteAsync(BASE_PATH + "/runs/" + runId);
    }
}
