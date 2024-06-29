package com.lbw.springjpapractices.domain.account.entity;

import com.lbw.springjpapractices.domain.account.dto.req.AddressUpdateReq;
import com.lbw.springjpapractices.global.embedded.address.Address;
import com.lbw.springjpapractices.global.embedded.email.Email;
import com.lbw.springjpapractices.global.embedded.password.Password;
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

    @Embedded
    private Password password;

    @Embedded
    private Address address;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime cratedAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public void updateMyAccount(AddressUpdateReq req) {
        this.address = req.getAddress();
    }
}
