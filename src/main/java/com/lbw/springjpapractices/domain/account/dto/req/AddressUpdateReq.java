package com.lbw.springjpapractices.domain.account.dto.req;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressUpdateReq {
    private String city;
    private String region;
    private String zip;
}
