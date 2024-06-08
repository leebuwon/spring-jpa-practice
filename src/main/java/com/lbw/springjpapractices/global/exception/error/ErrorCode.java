package com.lbw.springjpapractices.global.exception.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@Getter
public enum ErrorCode {
    NOT_FOUND_ACCOUNT_ERROR(BAD_REQUEST,400, "현재 존재하는 이메일 입니다."),;

    private final HttpStatus status;
    private final int code;
    private final String message;

    ErrorCode(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
