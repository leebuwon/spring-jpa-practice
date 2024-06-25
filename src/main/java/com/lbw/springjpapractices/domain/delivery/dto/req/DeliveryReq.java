package com.lbw.springjpapractices.domain.delivery.dto.req;

import com.lbw.springjpapractices.domain.address.Address;
import com.lbw.springjpapractices.domain.delivery.entity.Delivery;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryReq {

    @Valid
    private Address address;

    public static Delivery toEntity(DeliveryReq dto) {
        return Delivery.builder()
                .address(dto.getAddress())
                .build();
    }
}
