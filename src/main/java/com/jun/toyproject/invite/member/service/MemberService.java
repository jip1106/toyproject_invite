package com.jun.toyproject.invite.member.service;


import com.jun.toyproject.invite.member.model.dto.MemberDetailDto;
import com.jun.toyproject.invite.member.model.request.MemberRequest;
import com.jun.toyproject.invite.member.model.response.MemberDetailResponse;
import com.jun.toyproject.invite.member.model.response.MemberResponse;


public interface MemberService {
    //void insertMember(MemberRequest memberDto);

    /**
     * 회원 가입
     * @param memberRequest
     * @return
     */
    MemberResponse insertMember(MemberRequest memberRequest);

    Long countByMemberId(String memberId);

    MemberDetailDto findByMemberId(String memberId);

    MemberDetailResponse getMemberInfo(Long memberSeq, String memberId);

    boolean isMember(String inputPassword, MemberDetailDto memberDetailDto);



}
