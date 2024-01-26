package com.jun.toyproject.invite.common.type;

import lombok.Getter;

@Getter
public enum MemberType {
    ADMIN("관리자"),
    USER("회원");

    private final String name;

    MemberType(String name){
        this.name = name;
    }

}
