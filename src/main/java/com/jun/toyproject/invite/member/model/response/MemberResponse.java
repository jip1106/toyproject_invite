package com.jun.toyproject.invite.member.model.response;

import com.jun.toyproject.invite.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {

    @Schema(description = "회원 시퀀스")
    private Long memberSeq;

    @Schema(description = "회원 아이디")
    private String memberId;

    public MemberResponse(Long memberSeq, String memberId ){
        this.memberSeq = memberSeq;
        this.memberId = memberId;
    }

    public static MemberResponse from(Member member){
        return new MemberResponse(member.getMemberSeq(), member.getMemberId());
    }
}
