package com.lbw.springjpapractices.domain.account.dto.req;

import com.lbw.springjpapractices.domain.account.entity.Account;
import com.lbw.springjpapractices.domain.email.Email;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignupReq {
    // 유효성 검사 실패시 MethodArgumentNotValidException 발생
    @Valid
    private Email email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String city;
    @NotEmpty
    private String region;
    @NotEmpty
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
