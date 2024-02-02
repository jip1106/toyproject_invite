package com.jun.toyproject.invite.member.model.dto;

import com.jun.toyproject.invite.common.type.LoginType;
import com.jun.toyproject.invite.common.type.MemberType;
import com.jun.toyproject.invite.member.entity.Member;
import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class RegiMemberDto {

    private String name;
    private String memberId;
    private String password;
    private String email;
    private MemberType memberType;
    private LoginType loginType;



    public Member transDtoToEntity(RegiMemberDto memberDto){
        return new Member(memberDto);
    }

}
