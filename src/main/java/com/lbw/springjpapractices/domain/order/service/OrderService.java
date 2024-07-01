package com.lbw.springjpapractices.domain.order.service;

import com.lbw.springjpapractices.domain.coupon.entity.Coupon;
import com.lbw.springjpapractices.domain.coupon.service.CouponService;
import com.lbw.springjpapractices.domain.order.dto.req.OrderReq;
import com.lbw.springjpapractices.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final CouponService couponService;
    private final OrderRepository orderRepository;

    @Transactional
    public void addOrder(OrderReq dto) {
        Coupon coupon = null;

        if (dto.getCouponId() != null){
            coupon = couponService.findById(dto.getCouponId());
            if (coupon.isActive()){ // false -> 사용 X | true -> 사용 O
                throw new IllegalArgumentException("현재 쿠폰은 사용한 쿠폰입니다.");
            }

            coupon.update(); // 쿠폰 사용으로 업데이트
        }

        orderRepository.save(OrderReq.toEntity(dto, coupon));

    }
}
