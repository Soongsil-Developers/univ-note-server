package com.uninote.controller;

import com.uninote.dto.request.NoteCreate;
import com.uninote.dto.request.NoteEdit;
import com.uninote.dto.response.NoteResponse;
import com.uninote.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid NoteCreate request) {
        noteService.write(request);
    }

    @DeleteMapping("/delete/{noteId}")
    public void delete(@PathVariable Long noteId) {
        noteService.delete(noteId);
    }

    @GetMapping("/posts/{noteId}")
    public NoteResponse get(@PathVariable Long noteId) {
        return noteService.get(noteId);
    }

    @PatchMapping("/posts/{noteId}")
    public void edit(@PathVariable Long noteId, @RequestBody @Valid NoteEdit request) {
        noteService.edit(noteId, request);
    }
}
