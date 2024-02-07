package com.jun.toyproject.invite.member.model.dto;

import com.jun.toyproject.invite.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetailDto {

    private Long memberSeq;
    private String memberId;
    private String password;

    public static MemberDetailDto of(Member member){
        return new MemberDetailDto(
                member.getMemberSeq(),
                member.getMemberId(),
                member.getPassword()
        );
    }

}
