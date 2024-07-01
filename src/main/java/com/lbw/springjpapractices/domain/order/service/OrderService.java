package com.lbw.springjpapractices.domain.order.service;

import com.lbw.springjpapractices.domain.coupon.service.CouponService;
import com.lbw.springjpapractices.domain.order.dto.req.OrderReq;
import com.lbw.springjpapractices.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        orderRepository.save(OrderReq.toEntity(dto));
    }
}
