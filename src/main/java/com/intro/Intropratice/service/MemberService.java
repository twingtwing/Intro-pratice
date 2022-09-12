package com.intro.Intropratice.service;

import com.intro.Intropratice.domain.Member;
import com.intro.Intropratice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository mr;

    @Autowired
    public MemberService(MemberRepository mr) {
        this.mr = mr;
    }

    public String join(Member member){
        validateDupli(member);

        mr.join(member);
        return member.getId();
    }

    public Optional<Member> login(Member member){
        return mr.login(member);
    }

    public String withDraw(Member member){
        mr.withDraw(member);
        return member.getId();
    }

    public Optional<Member> memberOne(String id){
        return mr.findById(id);
    }

    public List<Member> members(){
        return mr.members();
    }

    public void validateDupli(Member member){
        mr.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
