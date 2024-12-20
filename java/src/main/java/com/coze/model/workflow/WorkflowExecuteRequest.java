package com.coze.model.workflow;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;


public class WorkflowExecuteRequest extends CozeModel {
    private final String workflowId;
    private final Map<String, Object> input;
    private final WorkflowRunMode mode;

    private WorkflowExecuteRequest(Builder builder) {
        this.workflowId = builder.workflowId;
        this.input = builder.input;
        this.mode = builder.mode;
    }

    @JsonProperty("workflow_id")
    public String getWorkflowId() {
        return workflowId;
    }

    public Map<String, Object> getInput() {
        return input;
    }

    public WorkflowRunMode getMode() {
        return mode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String workflowId;
        private Map<String, Object> input;
        private WorkflowRunMode mode;

        @JsonProperty("workflow_id")
        public Builder workflowId(String workflowId) {
            this.workflowId = workflowId;
            return this;
        }

        public Builder input(Map<String, Object> input) {
            this.input = input;
            return this;
        }

        public Builder mode(WorkflowRunMode mode) {
            this.mode = mode;
            return this;
        }

        public WorkflowExecuteRequest build() {
            return new WorkflowExecuteRequest(this);
        }
    }
}
