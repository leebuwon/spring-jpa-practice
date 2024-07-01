package com.lbw.springjpapractices.domain.coupon.dto.req;

import com.lbw.springjpapractices.domain.coupon.entity.Coupon;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponReq {

    private double discountAmount;

    public static Coupon toEntity(CouponReq dto){
        return Coupon.builder()
                .discountAmount(dto.getDiscountAmount())
                .active(false)
                .build();
    }
}
