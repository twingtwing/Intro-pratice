package com.intro.Intropratice.repository;

import com.intro.Intropratice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member join(Member member);
    void withDraw(Member member);
    Optional<Member> login(Member member);
    Optional<Member> findById(String id);
    List<Member> members();

}
