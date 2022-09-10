package com.uninote.repository;

import com.uninote.domain.Member;
import com.uninote.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value = "SELECT M FROM Member M WHERE M.nickname = :nickname")
    Optional<Member> findMemberByNickname(@Param("nickname") String nickname);
}
