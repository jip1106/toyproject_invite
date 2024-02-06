package com.jun.toyproject.invite.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * API 예외처리 RestController 예외를 전부 여기서 처리할지.. 클래스별로 따로 만들지..
 * */
@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalApiExceptionHandler {


    @ExceptionHandler(InviteException.class)
    public ResponseEntity<String> handleInviteException(InviteException ex){
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }


/*
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예기치 못한 오류 발생");
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDtaAccessException(EmptyResultDataAccessException ex){
        log.info("ex.getMessage() : {}" , ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("회원 정보가 없습니다.");
    }
*/




}
