package com.lbw.springjpapractices.global.exception;

import com.lbw.springjpapractices.global.exception.error.ErrorResponse;
import com.lbw.springjpapractices.global.exception.error.GlobalError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorResponse handleMethodArgNotValidException(MethodArgumentNotValidException e){
        log.info(e.getMessage());

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        List<ErrorResponse.FieldError> errors = fieldErrors.stream()
                .map(error -> ErrorResponse.FieldError.builder()
                        .field(error.getField())
                        .value((error.getRejectedValue() != null ? error.getRejectedValue().toString() : null))
                        .reason(error.getDefaultMessage())
                        .build())
                .toList();

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Validation failed")
                .code(HttpStatus.BAD_REQUEST.value())
                .errors(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse).getBody();
    }

    /**
     * custom 예외
     */
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> globalException(GlobalException ex) {
        GlobalError error = ex.getError();

        ErrorResponse response = ErrorResponse.builder()
                .code(error.getCode().getCode())
                .message(error.getMessage())
                .build();

        return ResponseEntity.status(error.getCode().getCode()).body(response);
    }
}
