package com.geeks.danda.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLogin {

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("password")
    private String password;
}

