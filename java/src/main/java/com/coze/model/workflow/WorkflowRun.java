package com.coze.model.workflow;

import com.coze.model.CozeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class WorkflowRun extends CozeModel {
    private final String id;
    private final String workflowId;
    private final WorkflowRunStatus status;
    private final Map<String, Object> input;
    private final Map<String, Object> output;
    private final String error;
    private final long startTime;
    private final long endTime;

    private WorkflowRun(Builder builder) {
        this.id = builder.id;
        this.workflowId = builder.workflowId;
        this.status = builder.status;
        this.input = builder.input;
        this.output = builder.output;
        this.error = builder.error;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public String getId() {
        return id;
    }

    @JsonProperty("workflow_id")
    public String getWorkflowId() {
        return workflowId;
    }

    public WorkflowRunStatus getStatus() {
        return status;
    }

    public Map<String, Object> getInput() {
        return input;
    }

    public Map<String, Object> getOutput() {
        return output;
    }

    public String getError() {
        return error;
    }

    @JsonProperty("start_time")
    public long getStartTime() {
        return startTime;
    }

    @JsonProperty("end_time")
    public long getEndTime() {
        return endTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String workflowId;
        private WorkflowRunStatus status;
        private Map<String, Object> input;
        private Map<String, Object> output;
        private String error;
        private long startTime;
        private long endTime;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @JsonProperty("workflow_id")
        public Builder workflowId(String workflowId) {
            this.workflowId = workflowId;
            return this;
        }

        public Builder status(WorkflowRunStatus status) {
            this.status = status;
            return this;
        }

        public Builder input(Map<String, Object> input) {
            this.input = input;
            return this;
        }

        public Builder output(Map<String, Object> output) {
            this.output = output;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        @JsonProperty("start_time")
        public Builder startTime(long startTime) {
            this.startTime = startTime;
            return this;
        }

        @JsonProperty("end_time")
        public Builder endTime(long endTime) {
            this.endTime = endTime;
            return this;
        }

        public WorkflowRun build() {
            return new WorkflowRun(this);
        }
    }
}
