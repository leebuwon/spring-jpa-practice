package com.lbw.springjpapractices.domain.account.dto.req;

import com.lbw.springjpapractices.domain.address.Address;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressUpdateReq {
    @Valid
    private Address address;
}
