package com.lbw.springjpapractices.domain.order.dto.req;

import com.lbw.springjpapractices.domain.coupon.entity.Coupon;
import com.lbw.springjpapractices.domain.order.entity.Order;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderReq {

    private double price;
    private Long couponId;

    public static Order toEntity(OrderReq dto, Coupon coupon){
        return Order.builder()
                .price(dto.getPrice() - (coupon != null ? coupon.getDiscountAmount() : 0))
                .coupon(coupon)
                .build();
    }
}
