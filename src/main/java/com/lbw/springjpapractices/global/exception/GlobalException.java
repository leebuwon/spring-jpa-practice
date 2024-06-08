package com.lbw.springjpapractices.global.exception;

import com.lbw.springjpapractices.global.exception.error.ErrorCode;
import com.lbw.springjpapractices.global.exception.error.GlobalError;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException{

    private final GlobalError error;

    public GlobalException(ErrorCode code) {
        super(code.getMessage());
        this.error = GlobalError.of(code);
    }
}
