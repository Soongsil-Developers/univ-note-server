package com.uninote.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NoteEditor {

    private final String title;

    private final String content;

    @Builder
    public NoteEditor(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
