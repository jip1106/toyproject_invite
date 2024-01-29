package com.jun.toyproject.invite.common.type;

import lombok.Getter;

@Getter
public enum InviteType {

    DEFAULT("일반초대장"),
    MARRY("청첩장"),
    BIRTH("생일");

    private final String name;
    InviteType(String name){
        this.name = name;
    }

}
