package com.lbw.springjpapractices.controller;

import com.lbw.springjpapractices.domain.delivery.dto.req.DeliveryReq;
import com.lbw.springjpapractices.domain.delivery.entity.Delivery;
import com.lbw.springjpapractices.domain.delivery.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid DeliveryReq dto){
        deliveryService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
