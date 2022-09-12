package com.intro.Intropratice.controller;

import com.intro.Intropratice.domain.Member;
import com.intro.Intropratice.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/join")
    public String join(){
        return "members/join";
    }

    @PostMapping("members/join")
    public String joinFrom(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("members/login")
    public String login(){
        return "members/login";
    }

    @PostMapping("members/login")
    public String loginForm(MemberForm form,Model model){
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());

        if(memberService.login(member).isPresent()){
            model.addAttribute("members",memberService.members());
            model.addAttribute("form",form);
            return "members/members";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("members/members")
    public String members(){
        return "members/members";
    }

    @GetMapping("members/withdraw")
    public String withdraw(MemberForm memberForm){
        Member member = new Member();
        member.setId(memberForm.getId());
        memberService.withDraw(member);
        return "home";
    }

}
