package com.geeks.danda.constants;

import java.util.Arrays;

public enum TaskStatuses {

    PENDING("P", "Pending"),
    PAUSED("U", "Paused"),
    WORKING("W", "Working"),
    COMPLETED("C", "Completed"),
    FAILED("F", "Failed"),
    RETRY("R", "Pending");

    private final String code;
    private final String details;

    TaskStatuses(String code, String details) {
        this.code = code;
        this.details = details;
    }

    public TaskStatuses getStatus(String code) {
        return Arrays.stream(TaskStatuses.values()).filter(task -> code.equals(task.getCode()) || code.equals(task.getDetails())).findFirst().orElse(null);
    }

    public String getCode() {
        return this.code;
    }

    public String getDetails() {
        return this.details;
    }
}
