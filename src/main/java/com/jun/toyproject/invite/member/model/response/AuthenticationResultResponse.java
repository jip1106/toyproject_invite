package com.jun.toyproject.invite.member.model.response;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthenticationResultResponse {

    private boolean success;

    private MemberDetailResponse memberDetailResponse;  //로그인 성공시 사용자 정보

    public AuthenticationResultResponse(boolean success){
        this.success = success;
    }

    public AuthenticationResultResponse(boolean success, MemberDetailResponse memberDetailResponse){
        this.success = success;
        this.memberDetailResponse = memberDetailResponse;
    }


}
