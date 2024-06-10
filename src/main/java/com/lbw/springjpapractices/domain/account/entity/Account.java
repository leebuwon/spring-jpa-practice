package com.lbw.springjpapractices.domain.account.entity;

import com.lbw.springjpapractices.domain.account.dto.req.AddressUpdateReq;
import com.lbw.springjpapractices.domain.email.Email;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 매개변수가 없는 생성자를 생성하되 다른 패키지에 소속된 클래스는 접근을 할 수 없다.
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Email email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime cratedAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public void updateMyAccount(AddressUpdateReq req){
        this.city = req.getCity();
        this.region = req.getRegion();
        this.zip = req.getZip();

    }
}
