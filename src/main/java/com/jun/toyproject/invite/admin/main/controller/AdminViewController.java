package com.jun.toyproject.invite.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    private final static String FOLDER_PREFIX = "/admin/";

    @GetMapping("/")
    public String adminHome(){
        return FOLDER_PREFIX + "index";
    }

    @GetMapping("/login")
    public String adminLoginPage(){
        return FOLDER_PREFIX + "login";
    }
}
