package com.jun.toyproject.invite.user.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

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

    @GetMapping("/user/signup")
    public String signupPage(){
        return "/member/signup";
    }


}
