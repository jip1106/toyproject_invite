package com.jun.toyproject.invite.member.controller;

import com.jun.toyproject.invite.member.dto.RegiMemberDto;
import com.jun.toyproject.invite.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return "ok";
    }
}
