package com.lbw.springjpapractices.domain.account.exception;

import com.lbw.springjpapractices.global.exception.GlobalException;
import com.lbw.springjpapractices.global.exception.error.ErrorCode;

public class NotFoundAccountException extends GlobalException {
    public NotFoundAccountException(ErrorCode code) {
        super(code);
    }
}
