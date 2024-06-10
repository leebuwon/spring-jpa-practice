package com.lbw.springjpapractices.domain.account.dto.res;

import com.lbw.springjpapractices.domain.account.entity.Account;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountRes {

    private String email;
    private String city;
    private String region;
    private String zip;

    public static AccountRes of(Account account){
        return AccountRes.builder()
                .email(account.getEmail().getEmail())
                .city(account.getAddress().getCity())
                .region(account.getAddress().getRegion())
                .zip(account.getAddress().getZip())
                .build();

    }
}
