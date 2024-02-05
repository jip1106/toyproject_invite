package com.jun.toyproject.invite.user.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/user/signup")
    public String signupPage(){
        return "/member/signup";
    }
    
    /**
     * 회원가입 결과 form
     */
    @GetMapping("/user/signup/result")
    public String signUpResultPage(){
        return "/member/result";
    }


    /**
     * 로그인 페이지
     */
    @GetMapping("/user/login")
    public String loginPage(){ return "/member/login";}



}
