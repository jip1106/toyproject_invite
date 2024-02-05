package com.jun.toyproject.invite.member.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jun.toyproject.invite.member.entity.Member;
import com.jun.toyproject.invite.member.model.request.LoginRequest;
import com.jun.toyproject.invite.member.model.request.MemberRequest;
import com.jun.toyproject.invite.member.model.response.AuthenticationResultResponse;
import com.jun.toyproject.invite.member.model.response.MemberDetailResponse;
import com.jun.toyproject.invite.member.model.response.MemberResponse;
import com.jun.toyproject.invite.member.service.MemberService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "members", description = "회원 관련 API")
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/user/signup")
    @Operation(summary = "회원 가입", description = "회원 가입 폼을 작성하고 회원 가입 버튼을 누른다.")
    public MemberResponse signUpMember(@RequestBody MemberRequest memberRequest){

        return memberService.insertMember(memberRequest);
    }

    /**
     * 아이디 중복 확인
     */
    @GetMapping("/user/idcheck/{memberId}")
    @Operation(summary = "id 중복확인", description = "회원 가입 폼에서 id 값에 값을 입력할 때 중복 확인을 진행한다.")
    public Long countByMemberId(@PathVariable("memberId") String memberId){
        log.info("memberId :: {} ", memberId);

        return memberService.countByMemberId(memberId);
    }

    /**
     * 회원 정보 조회
     * */
    @GetMapping("/user/{memberSeq}/{memberId}")
    @Operation(summary = "회원 정보 조회" , description = "회원 id,seq 로 회원 정보를 조회한다.")
    public MemberDetailResponse signUpResult(@PathVariable("memberId") String memberId, @PathVariable("memberSeq") Long memberSeq){
        log.info("/user/{}/{}" , memberSeq, memberId);

        return memberService.getMemberInfo(memberSeq, memberId);

    }


    @PostMapping("/user/login")
    @Operation(summary = "로그인", description = "로그인을 진행한다",
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200"),
                @ApiResponse(description = "Not found" , responseCode = "500"),
                @ApiResponse(description = "Authentication Failure" , responseCode = "401")
            }
    )
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest , HttpSession session){
        String memberId = loginRequest.getMemberId();
        String password = loginRequest.getPassword();

        AuthenticationResultResponse loginResult =
                memberService.isMember(memberId, password);

        if(loginResult.isSuccess() ){
            MemberDetailResponse memberInfo = loginResult.getMemberDetailResponse();

            session.setAttribute("sMemberName", memberInfo.getName());
            session.setAttribute("sMemberId", memberInfo.getMemberId());

            return ResponseEntity.status(HttpStatus.OK).body("로그인에 성공했습니다.");
        }else{
            MemberDetailResponse memberInfo = memberService.getMemberInfo(memberId);
            if(memberInfo.getMemberId() != null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호가 일치하지 않습니다.");
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("회원 정보가 없습니다.");
            }

        }
    }


    @PostMapping("/logout")
    @Operation(summary = "로그아웃", description = "로그아웃")
    public ResponseEntity<?> logOut(HttpSession session){
        session.invalidate();
        return ResponseEntity.status(HttpStatus.OK).body("로그아웃");
    }




}
