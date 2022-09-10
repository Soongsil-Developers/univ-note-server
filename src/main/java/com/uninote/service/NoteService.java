package com.uninote.service;

import com.uninote.domain.BookMark;
import com.uninote.domain.Member;
import com.uninote.domain.Note;
import com.uninote.domain.NoteEditor;
import com.uninote.dto.request.NoteCreate;
import com.uninote.dto.request.NoteEdit;
import com.uninote.dto.response.NoteResponse;
import com.uninote.exception.NoteNotFound;
import com.uninote.repository.MemberRepository;
import com.uninote.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final MemberRepository memberRepository;

    public void write(NoteCreate noteCreate) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Optional<Member> memberByNickname = memberRepository.findMemberByNickname(username);
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

    public void delete(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(NoteNotFound::new);

        noteRepository.delete(note);
    }

    public NoteResponse get(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(NoteNotFound::new);

        return NoteResponse.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }

    @Transactional
    public void edit(Long id, NoteEdit noteEdit) {
        Note note = noteRepository.findById(id)
                .orElseThrow(NoteNotFound::new);

        NoteEditor.NoteEditorBuilder editorBuilder = note.toEditor();

        NoteEditor noteEditor = editorBuilder.title(noteEdit.getTitle())
                .content(noteEdit.getContent())
                .build();

        note.edit(noteEditor);
    }
}
