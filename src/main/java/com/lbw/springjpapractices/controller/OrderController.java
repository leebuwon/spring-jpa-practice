package com.lbw.springjpapractices.controller;

import com.lbw.springjpapractices.domain.order.dto.req.OrderReq;
import com.lbw.springjpapractices.domain.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> addOrder(@Valid @RequestBody OrderReq dto){
        orderService.addOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
