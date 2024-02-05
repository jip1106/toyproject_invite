package com.jun.toyproject.invite.member.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequest {

    @Schema(description = "회원 아이디")
    private String memberId;
    
    @Schema(description = "회원 비밀번호")
    private String password;
}
