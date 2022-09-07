package com.intro.Intropratice.service;

import com.intro.Intropratice.domain.Member;
import com.intro.Intropratice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository mr;

    public MemberService(MemberRepository mr) {
        this.mr = mr;
    }

    public String join(Member member){
        validateDupli(member.getId());

        mr.join(member);
        return member.getId();
    }

    public Optional<Member> login(Member member){
        return mr.login(member);
    }

    public void withDraw(Member member){
        mr.withDraw(member);
    }

    public Optional<Member> memberOne(Member member){
        return mr.findById(member.getId());
    }

    public List<Member> members(){
        return mr.members();
    }

    public void validateDupli(String id){
        mr.findById(id)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
