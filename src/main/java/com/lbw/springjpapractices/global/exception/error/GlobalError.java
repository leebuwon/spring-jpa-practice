package com.lbw.springjpapractices.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GlobalError {

    private ErrorCode code;
    private String message;
    private String logMessage;

    public static GlobalError of(ErrorCode code) {
        return GlobalError.builder()
                .code(code)
                .message(code.getMessage())
                .logMessage(code.getMessage())
                .build();
    }
}
