package com.lbw.springjpapractices.domain.password;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.WithBy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Embeddable
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Password {

    @Column(name = "password", nullable = false)
    private String value;

    @Column(name = "password_expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "password_failed_count", nullable = false)
    private int failedCount;

    @Column(name = "password_ttl")
    private long ttl;

    public boolean isMatched(final String rawPassword){
        if(failedCount >= 5){
            throw new IllegalArgumentException("비밀번호를 5번이상 틀리셨습니다.");
        }

        final boolean matcheds = isMatched(rawPassword);
        updateFailedCount(matcheds);
        return matcheds;
    }

    public void changePassword(final String newPassword, final String oldPassword){
        if (isMatched(oldPassword)) {
            value = encodePassword(newPassword);
            extendExpirationDate();
        }
    }

    private void updateFailedCount(boolean matches) {
        if (matches)
            resetFailedCount();
        else
            increaseFailCount();
    }

    private void resetFailedCount() {
        this.failedCount = 0;
    }

    private void increaseFailCount() {
        this.failedCount++;
    }

    private String encodePassword(final String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    private LocalDateTime extendExpirationDate() {
        return LocalDateTime.now().plusSeconds(ttl);
    }
}
