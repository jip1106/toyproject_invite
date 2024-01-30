package com.jun.toyproject.invite.member.controller;

import com.jun.toyproject.invite.member.dto.RegiMemberDto;
import com.jun.toyproject.invite.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 사이트 회원 가입
     */
    @PostMapping("/user/signup")
    public String insertMember(@ModelAttribute RegiMemberDto memberDto){
        log.info("MemberController {} " , memberDto);

        memberService.insertMember(memberDto);

        return "signup";
    }

    /**
     * 아이디 중복 확인
     */
    @GetMapping("/user/idcheck/{memberId}")
    public Long countByMemberId(@PathVariable("memberId") String memberId){
        log.info("memberId :: {} ", memberId);
        Long count = memberService.countByMemberId(memberId);

        return count;
    }
}
