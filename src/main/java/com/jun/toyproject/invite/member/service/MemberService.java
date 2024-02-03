package com.jun.toyproject.invite.member.service;

import com.jun.toyproject.invite.member.model.request.MemberRequest;

public interface MemberService {

    /**
     * 회원 등록
     */
    void insertMember(MemberRequest memberDto);

    Long countByMemberId(String memberId);
}
