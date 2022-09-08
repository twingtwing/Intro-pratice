package com.intro.Intropratice.repository;

import com.intro.Intropratice.domain.Member;
import com.intro.Intropratice.service.BeanConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

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
//
//    @Test
//    public Optional<Member> login(Member member) {
//        Member result =  em.createQuery("SELECT m FROM MEMBER m WHERE m.ID = :id AND m.PASSWORD = :password",Member.class)
//                .setParameter("id",member.getId())
//                .setParameter("password",member.getPassword())
//                .getSingleResult();
//        return Optional.ofNullable(result);
//    }
//
//    @Test
//    public Optional<Member> findById(String id) {
//        return Optional.ofNullable(em.find(Member.class,id));
//    }

//    @Test
//    public List<Member> members() {
//        return em.createQuery("SELECT m FROM MEMBER m",Member.class)
//                .getResultList();
//    }

}