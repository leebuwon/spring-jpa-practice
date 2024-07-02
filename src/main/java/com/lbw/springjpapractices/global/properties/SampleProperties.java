package com.lbw.springjpapractices.global.properties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "user")
@Validated
@Data
public class SampleProperties {
    @Email
    private String email;

    @NotEmpty
    private String nickname;
    private int age;
    private boolean auth;
    private double amount;

}
