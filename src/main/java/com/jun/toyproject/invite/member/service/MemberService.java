package com.jun.toyproject.invite.member.service;

import com.jun.toyproject.invite.member.dto.RegiMemberDto;

public interface MemberService {

    /**
     * 회원 등록
     */
    void insertMember(RegiMemberDto memberDto);

}