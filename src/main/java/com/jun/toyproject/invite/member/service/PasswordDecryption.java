package com.jun.toyproject.invite.member.service;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@Getter
public class PasswordDecryption {
    private final int strength = 12;

    private String password;
    private String decodePassword;
    private boolean success;


    public PasswordDecryption(Builder builder){
        this.password = builder.password;
        // 암호화 진행
        this.decodePassword = builder.decodePassword;
        this.success = isSuccess(builder.password,builder.decodePassword);
    }


    private boolean isSuccess(String password, String decodePassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);

        return passwordEncoder.matches(password, decodePassword);
    }

    public static class Builder{
        private final String password;          //사용자 입력 패스워드
        private final String decodePassword;    //db 패스워드

        public Builder(String password, String decodePassword){

            this.password = password;
            this.decodePassword = decodePassword;
        }

        public PasswordDecryption build(){
            return new PasswordDecryption(this);
        }

    }

}
