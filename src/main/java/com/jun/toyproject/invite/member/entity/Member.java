package com.jun.toyproject.invite.member.entity;

import com.jun.toyproject.invite.common.entity.BaseEntity;
import com.jun.toyproject.invite.common.type.SignupType;
import com.jun.toyproject.invite.common.type.MemberType;
import com.jun.toyproject.invite.member.model.request.MemberRequest;
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

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Enumerated(EnumType.STRING)
    private SignupType signupType;



    public Member(MemberRequest memberDto) {
        this.name = memberDto.getName();
        this.memberId = memberDto.getMemberId();
        this.password = memberDto.getPassword();
        this.email = memberDto.getEmail();
        this.memberType = memberDto.getMemberType();
        this.signupType = memberDto.getSignupType();
    }

    public Member(Builder builder){
        this.name = builder.name;
        this.memberId = builder.memberId;
        this.password = builder.password;
        this.email = builder.email;
        this.memberType = builder.memberType;
        this.signupType = builder.signupType;
    }


    public static class Builder{
        private final String name;
        private final String memberId;
        private final String password;
        private final String email;
        private final MemberType memberType;
        private final SignupType signupType;

        public Builder(MemberRequest memberRequest){
            this.name = memberRequest.getName();
            this.memberId = memberRequest.getMemberId();
            this.password = memberRequest.getPassword();
            this.email = memberRequest.getEmail();
            this.memberType = memberRequest.getMemberType();
            this.signupType = memberRequest.getSignupType();
        }

        public Member build(){
            return new Member(this);
        }


    }


}
