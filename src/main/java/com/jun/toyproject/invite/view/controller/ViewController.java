package com.jun.toyproject.invite.view.controller;

import com.jun.toyproject.invite.common.type.InviteType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ViewController {

    /**
     * sample page st
     * */
    @GetMapping({"/" , "/index"})
    public String goMainPage(){
        return "main";
    }

    @GetMapping("/example/generic")
    public String genericPage(){
        return "/example/generic";
    }

    @GetMapping("/example/elements")
    public String elementsPage(){
        return "/example/elements";
    }

    /**
     * sample page end
     * */


    /**
     * 회원가입 form
     */
    @GetMapping("/member/signup")
    public String signupPage(){
        return "/member/signup";
    }
    
    /**
     * 회원가입 결과 form
     */
    @GetMapping("/member/signup/result")
    public String signUpResultPage(){
        return "/member/result";
    }


    /**
     * 로그인 페이지
     */
    @GetMapping("/member/login")
    public String loginPage(){ return "/member/login";}


    /**
     * 초대장 등록 페이지
     */
    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("inviteTypes",InviteType.values());

        return "/create/create";
    }

    /**
     * 마이페이지
     */
    @GetMapping("/mypage")
    public String myPage(){return "/mypage/mypage_home";}



}
