package com.jun.toyproject.invite.member.service;

import com.jun.toyproject.invite.member.model.request.MemberRequest;
import com.jun.toyproject.invite.member.entity.Member;
import com.jun.toyproject.invite.member.model.response.AuthenticationResultResponse;
import com.jun.toyproject.invite.member.model.response.MemberDetailResponse;
import com.jun.toyproject.invite.member.model.response.MemberResponse;
import com.jun.toyproject.invite.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponse insertMember(MemberRequest memberRequest) {

        log.info("MemberServiceImpl memberRequest :: {} ", memberRequest);

        Member saveMember = memberRepository.save(new Member.Builder(memberRequest).build());

        log.info("saveMember :: {}, {} ",  saveMember.getMemberSeq(), saveMember.getMemberId());

        return MemberResponse.from(saveMember);

    }

    @Override
    @Transactional(readOnly = true)
    public Long countByMemberId(String memberId) {

        Long count = memberRepository.countByMemberId(memberId);

        return count;
    }

    @Override
    public MemberDetailResponse getMemberInfo(String memberId) {
        Member findMember = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new NoSuchElementException("회원 정보가 없습니다."));


        return MemberDetailResponse.of(findMember,"로그인 성공");
    }

    @Override
    public MemberDetailResponse getMemberInfo(Long memberSeq, String memberId) {

        log.info("============= query start ============ ");
        Member findMember = memberRepository.findByMemberSeqAndMemberId(memberSeq ,memberId)
                .orElseThrow(() -> new NoSuchElementException("회원 정보가 없습니다."));
        log.info("============= query end ============ ");

        return MemberDetailResponse.of(findMember, "회원 가입에 성공 했습니다.");
    }

    @Override
    public AuthenticationResultResponse isMember(String memberId, String password) {

        Member member = memberRepository.findByMemberIdAndPassword(memberId, password)
                .orElseGet(() -> null);

        if(member == null){
            return new AuthenticationResultResponse(false);
        }else{
            return new AuthenticationResultResponse(true, MemberDetailResponse.of(member,"로그인에 성공 했습니다."));
        }

    }


}
