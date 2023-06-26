package com.geeks.danda.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.time.Duration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTask {

    @JsonProperty("name")
    private String name;

    @JsonProperty("details")
    private String details;

    @JsonProperty("dead_line")
    private Date deadLine;

    @JsonProperty("time_estimation")
    private Duration timeEstimation;

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

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Duration getTimeEstimation() {
        return timeEstimation;
    }

    public void setTimeEstimation(Duration timeEstimation) {
        this.timeEstimation = timeEstimation;
    }

    @Override
    public String toString() {
        return "CreateTask{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", deadLine=" + deadLine +
                ", timeEstimation=" + timeEstimation +
                '}';
    }
}
