package com.lbw.springjpapractices.domain.delivery.service;

import com.lbw.springjpapractices.domain.delivery.dto.req.DeliveryReq;
import com.lbw.springjpapractices.domain.delivery.entity.Delivery;
import com.lbw.springjpapractices.domain.delivery.repository.DeliveryRepository;
import com.lbw.springjpapractices.domain.deliverylog.entity.DeliveryStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Transactional
    public void create(DeliveryReq dto) {
        Delivery delivery = DeliveryReq.toEntity(dto);
        delivery.addLog(DeliveryStatus.PENDING);
        deliveryRepository.save(delivery);
    }
}
