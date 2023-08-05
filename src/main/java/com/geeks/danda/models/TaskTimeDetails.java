package com.geeks.danda.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class TaskTimeDetails {

    private int taskId;

    private Date startAt;

    private Date endAt;

    public int getTaskId() {
        return taskId;
    }
}
