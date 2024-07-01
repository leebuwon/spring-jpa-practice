package com.lbw.springjpapractices.controller;

import com.lbw.springjpapractices.domain.coupon.dto.req.CouponReq;
import com.lbw.springjpapractices.domain.coupon.entity.Coupon;
import com.lbw.springjpapractices.domain.coupon.service.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<Void> addCoupon(@Valid @RequestBody CouponReq dto){
        couponService.addCoupon(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
