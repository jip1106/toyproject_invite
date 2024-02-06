package com.jun.toyproject.invite.member.service;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@Getter
public class PasswordEncryption {
    private final int strength = 12;

    private String password;
    private String encodePassword;


    public PasswordEncryption(Builder builder){
        this.password = builder.password;

        // 암호화 진행
        this.encodePassword = doEncode(builder.password);
    }

    private String doEncode(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(strength);
        return encoder.encode(password);
    }

    public static class Builder{
        private final String password;

        public Builder(String password){
            this.password = password;
        }

        public PasswordEncryption build(){
            return new PasswordEncryption(this);
        }

    }

}
