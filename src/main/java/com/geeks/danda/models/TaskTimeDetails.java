package com.geeks.danda.models;

import java.sql.Date;

public class TaskTimeDetails {

    private int taskId;

    private Date startAt;

    private Date endAt;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return "TaskTimeDetails{" +
                "taskId=" + taskId +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                '}';
    }
}
