package com.jun.toyproject.invite.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class InviteException extends RuntimeException{

    private boolean isSuccess;
    private String message;
    private HttpStatus httpStatus;

    public InviteException(String message){
        this.isSuccess = false;
        this.message = message;
    }

    public InviteException(String message, HttpStatus httpStatus){
        fillInStackTrace();
        this.isSuccess = false;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
