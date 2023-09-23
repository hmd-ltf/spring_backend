package com.geeks.danda.constants;

import java.util.Arrays;

public enum TaskStatuses {

    PENDING("P", "Pending"),
    PAUSED("U", "Paused"),
    WORKING("W", "Working"),
    COMPLETED("C", "Completed"),
    FAILED("F", "Failed"),
    RETRY("R", "Retry");

    private final String code;
    private final String status;

    TaskStatuses(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public TaskStatuses getStatus(String code) {
        return Arrays.stream(TaskStatuses.values()).filter(task -> code.equals(task.code()) || code.equals(task.status())).findFirst().orElse(null);
    }

    public String code() {
        return this.code;
    }

    public String status() {
        return this.status;
    }
}
