package com.uninote.service;

import com.uninote.domain.BookMark;
import com.uninote.domain.Member;
import com.uninote.domain.Note;
import com.uninote.dto.request.NoteCreate;
import com.uninote.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public void write(NoteCreate noteCreate) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Optional<Member> memberByNickname = noteRepository.findMemberByNickname(username);
        Member findMember = memberByNickname.get();

        Note note = Note.builder()
                .title(noteCreate.getTitle())
                .content(noteCreate.getContent())
                .mainCategory(noteCreate.getMainCategory())
                .subCategory(noteCreate.getSubCategory())
                .bookMark(BookMark.BOOK_MARK_FALSE)
                .member(findMember)
                .build();

        noteRepository.save(note);
    }
}
