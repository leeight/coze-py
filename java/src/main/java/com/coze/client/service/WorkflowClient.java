package com.coze.client.service;

import com.coze.model.workflow.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

public class WorkflowClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/workflows";

    public WorkflowClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public WorkflowRun executeWorkflow(WorkflowExecuteRequest request) {
        return httpClient.post(BASE_PATH + "/execute", request, WorkflowRun.class);
    }

    public WorkflowRun getWorkflowRun(String runId) {
        return httpClient.get(BASE_PATH + "/runs/" + runId, WorkflowRun.class);
    }

    public List<WorkflowRun> listWorkflowRuns(String workflowId) {
        return httpClient.get(BASE_PATH + "/" + workflowId + "/runs",
            new TypeReference<List<WorkflowRun>>() {});
    }

    public void cancelWorkflowRun(String runId) {
        httpClient.post(BASE_PATH + "/runs/" + runId + "/cancel", null, Void.class);
    }

    public void deleteWorkflowRun(String runId) {
        httpClient.delete(BASE_PATH + "/runs/" + runId);
    }
}
