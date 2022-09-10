package com.uninote.repository;

import com.uninote.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query(value = "SELECT M FROM Member M WHERE M.nickname = :nickname")
    Optional<Member> findMemberByNickname(@Param("nickname") String nickname);
}
