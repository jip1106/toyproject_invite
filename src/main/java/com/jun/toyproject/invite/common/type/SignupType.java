package com.jun.toyproject.invite.common.type;

public enum SignupType {

    SITE("사이트 가입"),
    NAVER("네이버 연동"),
    KAKAO("카카오 연동"),
    GOOGLE("구글 연동");

    private final String message;

    SignupType(String message){
        this.message = message;
    }
}
