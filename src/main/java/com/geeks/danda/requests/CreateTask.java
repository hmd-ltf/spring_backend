package com.geeks.danda.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Duration;

@Data
@NoArgsConstructor
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

}
