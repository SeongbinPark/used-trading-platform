package com.seongbinpark.usedtradingplatform.member.repository;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
