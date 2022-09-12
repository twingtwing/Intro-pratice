package com.intro.Intropratice.repository;

import com.intro.Intropratice.domain.Member;
import com.intro.Intropratice.service.BeanConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(BeanConfig.class)
class MemberRepositoryTest {

    @Autowired private MemberRepository mr;

    @Test
    public void 회원가입(){
        //given
        Member member = new Member();
        member.setId("id");
        member.setPassword("password");

        //when
        member = mr.join(member);

        //then
        Member result = mr.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void 탈퇴() {
        //given
        Member member = new Member();
        member.setId("id");
        member.setPassword("password");

        member = mr.join(member);

        //when
        mr.withDraw(member);

        //then
        assertThat(mr.findById(member.getId()).isEmpty()).isEqualTo(true);

    }

    @Test
    public void 로그인() {
        //given
        Member member = new Member();
        member.setId("id");
        member.setPassword("password");

        //when
        mr.join(member);
        Member result = mr.login(member).get();

        //then
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void 로그인2() {
        //given
        Member member = new Member();
        member.setId("id");
        member.setPassword("password");

        //when

        //then
        mr.login(member).isEmpty();
    }

    @Test
    public void 아이디() {
        //given
        Member member = new Member();
        member.setId("id");
        member.setPassword("password");

        //when
        mr.join(member);
        Member result = mr.findById(member.getId()).get();

        //Then
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void 아이디2() {
        //given
        Member member = new Member();
        member.setId("id");
        member.setPassword("password");

        //when

        //Then
        mr.findById(member.getId()).isEmpty();
    }

    @Test
    public void members() {
        //given
        Member member = new Member();
        member.setId("id");
        member.setPassword("password");

        Member member2= new Member();
        member2.setId("id2");
        member2.setPassword("password2");

        //when
        mr.join(member);
        mr.join(member2);

        //then
        List<Member> result = mr.members();

        assertThat(result.size()).isEqualTo(2);

    }

}