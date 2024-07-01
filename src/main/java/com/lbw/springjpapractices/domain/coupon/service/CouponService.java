package com.lbw.springjpapractices.domain.coupon.service;

import com.lbw.springjpapractices.domain.coupon.dto.req.CouponReq;
import com.lbw.springjpapractices.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public void addCoupon(CouponReq dto) {
        couponRepository.save(CouponReq.toEntity(dto));
    }
}
