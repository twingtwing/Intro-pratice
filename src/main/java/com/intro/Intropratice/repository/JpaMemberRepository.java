package com.intro.Intropratice.repository;

import com.intro.Intropratice.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member join(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public void withDraw(Member member) {
        em.remove(member);
    }

    @Override
    public Optional<Member> login(Member member) {
        Member result =  em.createQuery("SELECT m FROM MEMBER m WHERE m.ID = :id AND m.PASSWORD = :password",Member.class)
                            .setParameter("id",member.getId())
                            .setParameter("password",member.getPassword())
                            .getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(em.find(Member.class,id));
    }

    @Override
    public List<Member> members() {
        return em.createQuery("SELECT m FROM MEMBER m",Member.class)
                .getResultList();
    }
}
