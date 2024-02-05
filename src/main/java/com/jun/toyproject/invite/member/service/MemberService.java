package com.jun.toyproject.invite.member.service;


import com.jun.toyproject.invite.member.model.request.MemberRequest;
import com.jun.toyproject.invite.member.model.response.AuthenticationResultResponse;
import com.jun.toyproject.invite.member.model.response.MemberDetailResponse;
import com.jun.toyproject.invite.member.model.response.MemberResponse;


public interface MemberService {

    /**
     * 회원 등록
     */
    //void insertMember(MemberRequest memberDto);
    MemberResponse insertMember(MemberRequest memberRequest);

    Long countByMemberId(String memberId);

    MemberDetailResponse getMemberInfo(String memberId);

    MemberDetailResponse getMemberInfo(Long memberSeq, String memberId);


    AuthenticationResultResponse isMember(String memberId, String password);
}
