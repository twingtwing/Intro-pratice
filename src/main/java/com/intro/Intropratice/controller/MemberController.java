package com.intro.Intropratice.controller;

import com.intro.Intropratice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/join")
    public String join(){
        return "members/join";
    }

    @PostMapping("/members/join")
    public String joinFrom(){
        return null;
    }

    @GetMapping("/members/login")
    public String login(){
        return "members/login";
    }

}
