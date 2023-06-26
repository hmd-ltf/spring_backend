package com.geeks.danda.models;

import com.geeks.danda.constants.TaskStatuses;

import java.sql.Date;
import java.util.List;

public class TaskDetails {

    private int id;

    private String name;

    private String details;

    private TaskStatuses taskStatus;

    private Date createdAt;

    private Date startedAt;

    private Date deadLine;

    private List<TaskTimeDetails> taskTimeDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public TaskStatuses getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatuses taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public List<TaskTimeDetails> getTaskTimeDetails() {
        return taskTimeDetails;
    }

    public void setTaskTimeDetails(List<TaskTimeDetails> taskTimeDetails) {
        this.taskTimeDetails = taskTimeDetails;
    }

    @Override
    public String toString() {
        return "TaskDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", taskStatus=" + taskStatus +
                ", createdAt=" + createdAt +
                ", startedAt=" + startedAt +
                ", deadLine=" + deadLine +
                ", taskTimeDetails=" + taskTimeDetails +
                '}';
    }
}
