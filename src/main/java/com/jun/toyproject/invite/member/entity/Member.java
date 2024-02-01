package com.jun.toyproject.invite.member.entity;

import com.jun.toyproject.invite.common.entity.BaseEntity;
import com.jun.toyproject.invite.common.type.LoginType;
import com.jun.toyproject.invite.common.type.MemberType;
import com.jun.toyproject.invite.member.model.dto.RegiMemberDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id @GeneratedValue
    private Long memberSeq;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false, length = 32)
    private String password;

    @Column(nullable = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;



    public Member(RegiMemberDto memberDto) {
        this.name = memberDto.getName();
        this.memberId = memberDto.getMemberId();
        this.password = memberDto.getPassword();
        this.email = memberDto.getEmail();
        this.memberType = memberDto.getMemberType();
        this.loginType = memberDto.getLoginType();
    }


}
