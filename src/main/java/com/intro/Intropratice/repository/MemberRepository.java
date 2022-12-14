package com.intro.Intropratice.repository;

import com.intro.Intropratice.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member join(Member member);
    Member withDraw(Member member);
    Optional<Member> login(Member member);
    Optional<Member> findById(String id);
    List<Member> members();

}
