package com.inno.tasks.request.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskDetailsRequestModel {
    @NotNull(message = "Task Name is Required")
    @Size(min = 5, message = "Task name must have 3 character minimum")
    private String taskName;

    @Size(min = 5, max = 30)
    private String taskDescription;

    @NotNull(message = "User Id is Required")
    @Size(min = 5, message = "User Id must have 3 character minimum")
    private String userId;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}