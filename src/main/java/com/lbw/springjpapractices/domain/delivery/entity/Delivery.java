package com.lbw.springjpapractices.domain.delivery.entity;

import com.lbw.springjpapractices.domain.address.Address;
import com.lbw.springjpapractices.domain.deliverylog.entity.DeliveryLog;
import com.lbw.springjpapractices.domain.deliverylog.entity.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Slf4j
@Table(name = "delivery")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @Builder.Default
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DeliveryLog> logs = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public void addLog(DeliveryStatus status) {
        this.logs.add(createLog(status));
    }

    private DeliveryLog createLog(DeliveryStatus status){
        return DeliveryLog.builder()
                .status(status)
                .delivery(this)
                .build();
    }
}
