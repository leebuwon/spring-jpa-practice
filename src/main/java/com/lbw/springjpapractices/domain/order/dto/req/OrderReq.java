package com.lbw.springjpapractices.domain.order.dto.req;

import com.lbw.springjpapractices.domain.order.entity.Order;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderReq {

    private double price;

    public static Order toEntity(OrderReq dto){
        return Order.builder()
                .price(dto.getPrice())
                .build();
    }
}
