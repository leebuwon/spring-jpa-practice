package com.lbw.springjpapractices.domain.password;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityListeners;
import lombok.*;
import lombok.experimental.WithBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    @Column(name = "password", nullable = false)
    private String value;

    @LastModifiedDate
    @Column(name = "password_expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "password_failed_count", nullable = false)
    private int failedCount;

    @Column(name = "password_ttl")
    private long ttl;
}
