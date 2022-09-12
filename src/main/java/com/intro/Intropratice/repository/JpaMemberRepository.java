package com.intro.Intropratice.repository;

import com.intro.Intropratice.domain.Member;
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
    public Member withDraw(Member member) {
        Member result = em.find(Member.class,member.getId());
        em.remove(result);
        return member;
    }

    @Override
    public Optional<Member> login(Member member) {
//        Member result =  em.createQuery("SELECT m FROM Member m WHERE m.id = :id AND m.password = :password", Member.class)
//                            .setParameter("id",member.getId())
//                            .setParameter("password",member.getPassword())
//                            .getSingleResult();
//        return Optional.ofNullable(result);
        return  em.createQuery("SELECT m FROM Member m WHERE m.id = :id AND m.password = :password", Member.class)
                .setParameter("id",member.getId())
                .setParameter("password",member.getPassword())
                .getResultList().stream().findFirst();
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(em.find(Member.class,id));
    }

    @Override
    public List<Member> members() {
        return em.createQuery("SELECT m FROM Member m",Member.class)
                .getResultList();
    }
}
