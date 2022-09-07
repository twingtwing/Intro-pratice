package com.intro.Intropratice.service;

import com.intro.Intropratice.domain.Member;
import com.intro.Intropratice.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
class MemberServiceTest {

    @Autowired
    MemberService ms;

//    @Test
//    public void 회원가입(){
//        //given
//        Member member = new Member();
//        member.setId("id");
//        member.setPassword("password");
//
//        //when
//        String id =  ms.join(member);
//
//        //then
//        Member result = ms.memberOne(member).get();
//        Assertions.assertThat(member.getPassword()).isEqualTo(result.getPassword());
//    }
//
//    @Test
//    public void 로그인(){
//        Member member = new Member();
//        member.setId("id");
//        member.setPassword("password");
//
//        String id =  ms.join(member);
//
//        Member result =  ms.login(member).get();
//
//    }

//    public void withDraw(Member member){
//        mr.withDraw(member);
//    }
//
//    public List<Member> members(){
//        return mr.members();
//    }
//
//    public void validateDupli(String id){
//        mr.findById(id)
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }

}