package com.lbw.springjpapractices.global.embedded.email;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;


@Getter
@Embeddable
public class Email {

    @jakarta.validation.constraints.Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
