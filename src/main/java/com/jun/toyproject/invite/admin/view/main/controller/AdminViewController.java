package com.jun.toyproject.invite.admin.view.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    private final static String VIEW_FOLDER = "admin/";


    @GetMapping({"", "/"})
    public String adminHome(){
        return VIEW_FOLDER + "index";
    }

    @GetMapping("/login")
    public String adminLoginPage(){
        return VIEW_FOLDER + "login";
    }

    @GetMapping("/buttons")
    public String buttonPage(){
        return VIEW_FOLDER + "default/buttons";
    }

    @GetMapping("/cards")
    public String cardsPage(){
        return VIEW_FOLDER + "default/cards";
    }
}
