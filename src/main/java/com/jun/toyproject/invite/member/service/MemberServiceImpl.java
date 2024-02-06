package com.jun.toyproject.invite.member.service;

import com.jun.toyproject.invite.common.exception.InviteException;
import com.jun.toyproject.invite.member.model.dto.MemberDetailDto;
import com.jun.toyproject.invite.member.model.request.MemberRequest;
import com.jun.toyproject.invite.member.entity.Member;
import com.jun.toyproject.invite.member.model.response.MemberDetailResponse;
import com.jun.toyproject.invite.member.model.response.MemberResponse;
import com.jun.toyproject.invite.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponse insertMember(MemberRequest memberRequest) {
        log.info("MemberServiceImpl memberRequest :: {} ", memberRequest);

        //비밀번호 암호화
        memberRequest.setPassword(
                new PasswordEncryption.Builder(memberRequest.getPassword()).build().getEncodePassword()
        );

        Member saveMember = memberRepository.save(new Member.Builder(memberRequest).build());

        log.info("saveMember :: {}, {} ",  saveMember.getMemberSeq(), saveMember.getMemberId());

        return MemberResponse.from(saveMember);

    }

    @Override
    @Transactional(readOnly = true)
    public Long countByMemberId(String memberId) {
        return memberRepository.countByMemberId(memberId);
    }

    @Override
    public MemberDetailDto findByMemberId(String memberId){
        Member findMember = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new InviteException("회원 정보가 없습니다.", HttpStatus.NOT_FOUND));


        return MemberDetailDto.of(findMember);
    }

    @Override
    public MemberDetailResponse getMemberInfo(Long memberSeq, String memberId) {

        Member findMember = memberRepository.findByMemberSeqAndMemberId(memberSeq ,memberId)
                .orElseThrow(() -> new InviteException("회원 정보가 없습니다.", HttpStatus.NOT_FOUND));

        /* errortest
        Member findMember = memberRepository.findByMemberSeqAndMemberId(memberSeq ,memberId)
                .orElseThrow(() -> new RuntimeException("500"));

         */


        return MemberDetailResponse.of(findMember, "회원 가입에 성공 했습니다.");
    }

    @Override
    public boolean isMember(String inputPassword ,MemberDetailDto memberDetailDto) {

        //복호화 진행
        PasswordDecryption build = new PasswordDecryption.Builder(inputPassword, memberDetailDto.getPassword())
                .build();

        return build.isSuccess();


    }


}
