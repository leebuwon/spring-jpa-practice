package com.lbw.springjpapractices.domain.coupon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lbw.springjpapractices.domain.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@Table(name = "coupons")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "discount_amount")
    private double discountAmount;

    @Column(name = "active")
    private boolean active;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "coupon")
    private Order order;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime cratedAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
