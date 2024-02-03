package com.jun.toyproject.invite.member.service;

import com.jun.toyproject.invite.member.model.request.MemberRequest;
import com.jun.toyproject.invite.member.entity.Member;
import com.jun.toyproject.invite.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void insertMember(MemberRequest memberDto) {

        log.info("MemberServiceImpl memberDto :: {} ", memberDto);

        Member saveMember = memberRepository.save(memberDto.transDtoToEntity(memberDto));

        log.info("saveMember :: {}, {} ",  saveMember.getMemberSeq(), saveMember.getMemberId());

    }

    @Override
    public Long countByMemberId(String memberId) {

        Long count = memberRepository.countByMemberId(memberId);

        return count;
    }


}
