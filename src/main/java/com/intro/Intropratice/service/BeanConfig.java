package com.intro.Intropratice.service;

import com.intro.Intropratice.repository.JpaMemberRepository;
import com.intro.Intropratice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class BeanConfig {

    private final EntityManager em;

    @Autowired
    public BeanConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

}
