package com.geeks.danda.models;

import com.geeks.danda.constants.TaskStatuses;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Duration;
import java.util.List;

@Data
@NoArgsConstructor
public class TaskDetails {

    private String name;

    private String details;

    private TaskStatuses taskStatus;

    private Date createdAt;

    private Date startedAt;

    private Date deadLine;

    private Duration timeEstimation;

    private Duration remainingTime;

    private List<TaskTimeDetails> taskTimeDetails;
}
