package com.lbw.springjpapractices.controller;

import com.lbw.springjpapractices.domain.account.dto.req.AddressUpdateReq;
import com.lbw.springjpapractices.domain.account.dto.req.MemberSignupReq;
import com.lbw.springjpapractices.domain.account.dto.res.AccountRes;
import com.lbw.springjpapractices.domain.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid MemberSignupReq dto){
        accountService.signup(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountRes> getUser(@PathVariable("id") final Long id){
        AccountRes dto = accountService.findAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMyAccount(@PathVariable("id") final Long id, @RequestBody AddressUpdateReq req){
        accountService.updateMyAccount(id, req);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
