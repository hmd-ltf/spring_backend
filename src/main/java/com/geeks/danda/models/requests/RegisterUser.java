package com.geeks.danda.models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUser {

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

}
