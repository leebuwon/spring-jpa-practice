package com.lbw.springjpapractices.domain.account.service;

import com.lbw.springjpapractices.domain.account.dto.req.AddressUpdateReq;
import com.lbw.springjpapractices.domain.account.dto.req.MemberSignupReq;
import com.lbw.springjpapractices.domain.account.dto.res.AccountRes;
import com.lbw.springjpapractices.domain.account.entity.Account;
import com.lbw.springjpapractices.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;
    @Transactional
    public void signup(MemberSignupReq dto) {
        accountRepository.save(MemberSignupReq.toEntity(dto));
    }

    public AccountRes findAccount(Long id) {
        Account account = findById(id);

        return AccountRes.of(account);
    }

    @Transactional
    public void updateMyAccount(Long id, AddressUpdateReq req) {
        Account account = findById(id);

        account.updateMyAccount(req);

    }

    public Account findById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("현재 존재하지 않는 멤버입니다."));
    }
}
