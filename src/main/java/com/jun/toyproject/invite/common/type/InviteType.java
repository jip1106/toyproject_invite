package com.jun.toyproject.invite.common.type;

public enum InviteType {

    DEFAULT("일반초대장"),
    MARRY("청첩장"),
    BIRTH("생일"),
    TEST1("테스트1"),
    TEST2("테스트2"),
    TEST3("테스트3"),
    TEST4("테스트4"),
    TEST5("테스트5");

    private final String name;
    InviteType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
