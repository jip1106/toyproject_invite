package com.jun.toyproject.invite.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example")
public class ViewController {

    @GetMapping("/generic")
    public String genericPage(){
        return "/example/generic";
    }

    @GetMapping("/elements")
    public String elementsPage(){
        return "/example/elements";
    }
}
