package com.lbw.springjpapractices.domain.account.dto.req;

import com.lbw.springjpapractices.domain.account.entity.Account;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignupReq {

    private String email;
    private String password;
    private String city;
    private String region;
    private String zip;

    public static Account toEntity(MemberSignupReq dto) {
        return Account.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .city(dto.getCity())
                .region(dto.getRegion())
                .zip(dto.getZip())
                .build();
    }
}
