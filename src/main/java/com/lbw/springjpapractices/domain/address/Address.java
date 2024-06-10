package com.lbw.springjpapractices.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @NotEmpty
    @Column(name = "city", nullable = false)
    private String city;

    @NotEmpty
    @Column(name = "region", nullable = false)
    private String region;

    @NotEmpty
    @Column(name = "zip", nullable = false)
    private String zip;
}
