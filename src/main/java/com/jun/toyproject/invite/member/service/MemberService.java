package com.jun.toyproject.invite.member.service;

import com.jun.toyproject.invite.member.model.dto.RegiMemberDto;

public interface MemberService {

    /**
     * 회원 등록
     */
    void insertMember(RegiMemberDto memberDto);

    Long countByMemberId(String memberId);
}
