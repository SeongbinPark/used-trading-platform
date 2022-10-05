package com.seongbinpark.usedtradingplatform.member.repository;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public boolean existsByEmail(String email);

    public Optional<Member> findMemberByEmail(String email);

}
