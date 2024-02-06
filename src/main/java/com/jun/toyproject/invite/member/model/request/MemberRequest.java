package com.jun.toyproject.invite.member.model.request;

import com.jun.toyproject.invite.common.type.MemberType;
import com.jun.toyproject.invite.common.type.SignUpType;
import com.jun.toyproject.invite.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
//@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class MemberRequest {

    @Schema(description = "회원이름")
    private String name;

    @Schema(description = "회원 ID")
    private String memberId;

    @Schema(description = "비밀번호")
    @Setter //암호화
    private String password;

    @Schema(description = "이메일")
    private String email;

    @Schema(description = "회원타입")
    private MemberType memberType;

    @Schema(description = "회원 가입 방식")
    private SignUpType signUpType;



}
