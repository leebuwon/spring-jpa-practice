package com.lbw.springjpapractices.domain.account.dto.req;

import com.lbw.springjpapractices.domain.account.entity.Account;
import com.lbw.springjpapractices.global.embedded.address.Address;
import com.lbw.springjpapractices.global.embedded.email.Email;
import com.lbw.springjpapractices.global.embedded.password.Password;
import jakarta.validation.Valid;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class MemberSignupReq {
    @Valid
    private Email email;
    @Valid
    private Password password;
    @Valid
    private Address address;

    public static Account toEntity(MemberSignupReq dto) {
        log.info("value = {}", dto.getPassword().getValue());
        return Account.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .address(dto.getAddress())
                .build();
    }
}